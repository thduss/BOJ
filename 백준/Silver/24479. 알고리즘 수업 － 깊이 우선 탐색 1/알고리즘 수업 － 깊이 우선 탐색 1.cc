#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

vector<int> arr[100001]; //간선
vector<bool> visited;
int order[100001]={0,}, cnt=1;

void dfs(int node, int n){
    if(visited[node]) return;

    visited[node] = true;
    order[node] = cnt++;

    for(int i=0; i<arr[node].size(); i++){
        dfs(arr[node][i], n);
    }
}
int main() {
    int n, m, r;
    cin >> n >> m >> r;

    visited.resize(n+1, false);
    
   for(int i=1; i<=m; i++){
        int u, v;
        cin >> u >> v;
        arr[u].push_back(v);
        arr[v].push_back(u);
   }

   for (int i = 1; i <= n; i++) {
		sort(arr[i].begin(), arr[i].end());
	}

   dfs(r, n);

   for(int i=1; i<=n; i++){
        cout << order[i] << "\n";
   }
}