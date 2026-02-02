import os

def generate_readme():
    file_path = 'problems.txt'

    # 1. 디버깅: 현재 위치와 파일 목록 출력 (로그에서 확인용)
    print(f"현재 작업 경로: {os.getcwd()}")
    print(f"현재 경로의 파일 목록: {os.listdir()}")

    # 2. 파일 존재 여부 확인
    if not os.path.exists(file_path):
        # 파일이 없으면 강제로 에러를 발생시켜서 빨간불을 띄움
        raise FileNotFoundError(f"❌ '{file_path}' 파일을 찾을 수 없습니다! 파일 이름(대소문자)과 위치를 확인해주세요.")

    # 3. 파일 읽기
    with open(file_path, 'r', encoding='utf-8') as f:
        problems = f.read().split()

    # 4. README 내용 생성
    content = "# 📂 백준 문제 풀이 목록\n\n"
    content += "| 문제 번호 | 바로가기 |\n"
    content += "| :---: | :--- |\n"

    for num in problems:
        if not num.strip(): continue # 공백 제거
        url = f"https://www.acmicpc.net/problem/{num}"
        content += f"| {num} | [문제 보러가기 🚀]({url}) |\n"

    # 5. README.md 덮어쓰기
    with open('README.md', 'w', encoding='utf-8') as f:
        f.write(content)
    
    print("✅ README.md 업데이트 완료!")

if __name__ == "__main__":
    generate_readme()