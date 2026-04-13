#include<iostream>
#include<vector>
#include<cmath>
using namespace std;

vector<int> v;
int n;
int ans;

bool isSafe(int idx) {
	for (int i = 0; i < idx; i++) {
		if (v[idx] == v[i]) return false;
		if (abs(v[i] - v[idx]) == abs(i - idx)) return false;
	}
	return true;
}

void dfs(int idx) {
	if (idx == n) {
		ans++;
		return;
	}
	for (int i = 0; i < n; i++) {
		v[idx] = i;
		if (isSafe(idx)) dfs(idx + 1);
	}
}

int main() {
	int t;
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		cin >> n;
		v.assign(n, 0);
		ans = 0;
		dfs(0);
		cout << "#" << tc << " " << ans << endl;
	}
}
