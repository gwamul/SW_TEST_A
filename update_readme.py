import json
import os

def generate_readme():
    json_path = 'study_plan.json'
    readme_path = 'README.md'

    if not os.path.exists(json_path):
        print(f"❌ '{json_path}' 파일이 없습니다.")
        return

    # 1. SWEA D2 Java 지원 문제 contestProbId 매핑 데이터
    # SWEA D2 난이도 Java 지원 문제 전체 매핑 데이터 (26개)
    swea_db = {
        21425: "AZD8K_UayDoDFAVs", # +=
        1859: "AV5LrsUaDxcDFAXc",  # 백만 장자 프로젝트
        1926: "AV5PTeo6DCADFAUq",  # 간단한 369게임
        2007: "AV5P1kNKAl8DFAUq",  # 패턴 마디의 길이
        2005: "AV5P0-h6Ak4DFAUq",  # 파스칼의 삼각형
        2001: "AV5PzOCKAigDFAUq",  # 파리 퇴치
        1989: "AV5PyTLqAf4DFAUq",  # 초심자의 회문 검사
        1986: "AV5PxmBqAe8DFAUq",  # 지그재그 숫자
        1984: "AV5Pw_-KAdcDFAUq",  # 중간 평균값 구하기
        1983: "AV5PwGK6AcIDFAUq",  # 조교의 성적 매기기
        1979: "AV5PuPq6AaQDFAUq",  # 어디에 단어가 들어갈 수 있을까
        1976: "AV5PttaaAZIDFAUq",  # 시각 덧셈
        1974: "AV5Pszm6QsQDFAUq",  # 스도쿠 검증
        1970: "AV5Ps16aByMDFAUq",  # 쉬운 거스름돈
        1966: "AV5PrmyKAExDFAUq",  # 숫자를 정렬하자
        1961: "AV5Pq-q6AYEDFAUq",  # 숫자 배열 회전
        1959: "AV5PpoFaA44DFAUq",  # 두 개의 숫자열
        1954: "AV5Pob_6ADcDFAUq",  # 달팽이 숫자
        1948: "AV5PnnU6AOsDFAUq",  # 날짜 계산기
        1946: "AV5PnmY6AnQDFAUq",  # 간단한 압축 풀기
        1945: "AV5Pl0Q6ANQDFAUq",  # 간단한 소인수분해
        1940: "AV5PjMgaALgDFAUq",  # 가랏! RC카!
        1928: "AV5PjKXKALcDFAUq",  # Base64 Decoder
        1288: "AV18_D--BA8CFAZN",  # 새로운 불면증 치료법
        1284: "AV1892K6AO8CFAZN",  # 수도 요금 경쟁
        1204: "AV134JS6AAASFAYh"   # 최빈수 구하기
    }

    def get_url(num):
        # DB에 ID가 있으면 상세 페이지, 없으면 검색 결과 페이지 링크 반환
        if num in swea_db:
            return f"https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId={swea_db[num]}"
        else:
            return f"https://swexpertacademy.com/main/code/problem/problemList.do?problemLevel=2&problemTitle={num}&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1"

    # JSON 데이터 로드
    with open(json_path, 'r', encoding='utf-8') as f:
        data = json.load(f)

    current_week_title = data['current_week']
    weeks_data = data['weeks']

    # 2. README 콘텐츠 생성
    content = "# 🐢 SWEA 알고리즘 스터디\n\n"
    content += "> 💡 **접속 가이드**: 링크 클릭 시 메인으로 이동한다면, **링크를 우클릭하여 '새 탭에서 열기'**를 하거나 주소를 복사해 주소창에 직접 붙여넣으세요.\n\n"

    # 3. 🔥 이번 주 도전 문제 (최상단)
    content += f"## 📅 이번 주 도전 문제 ({current_week_title})\n"
    content += "| 문제 번호 | 문제 이름 | 바로가기 |\n"
    content += "| :---: | :--- | :---: |\n"

    current_problems = next((w['problems'] for w in weeks_data if w['title'] == current_week_title), [])
    
    if not current_problems:
        content += "| - | 이번 주는 휴식 주간입니다 | - |\n"
    else:
        for num in current_problems:
            url = get_url(num)
            # rel="noreferrer"를 추가하여 외부 유입 차단 보안 우회
            link_tag = f'<a href="{url}" rel="noreferrer" target="_blank">문제 풀러 가기 🚀</a>'
            content += f"| {num} | SWEA {num}번 문제 | {link_tag} |\n"
    
    content += "\n---\n\n"

    # 4. 📚 지난 스터디 기록 (접이식)
    content += "## 📚 지난 기록\n"
    for week in reversed(weeks_data):
        if week['title'] == current_week_title:
            continue
            
        content += f"<details>\n<summary><b>{week['title']} (클릭하여 확장)</b></summary>\n\n"
        content += "| 문제 번호 | 링크 |\n"
        content += "| :---: | :--- |\n"
        
        for num in week['problems']:
            url = get_url(num)
            link_tag = f'<a href="{url}" rel="noreferrer" target="_blank">바로가기</a>'
            content += f"| {num} | {link_tag} |\n"
        
        content += "\n</details>\n\n"

    # 5. 파일 저장
    with open(readme_path, 'w', encoding='utf-8') as f:
        f.write(content)
    
    print(f"✅ {readme_path} 업데이트 완료!")

if __name__ == "__main__":
    generate_readme()