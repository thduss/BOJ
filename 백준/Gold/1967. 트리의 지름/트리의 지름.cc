#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

int n,result, endPoint=0; // 노드 개수
vector<pair<int,int> > node[100000];
bool visited[100000] ={false,};

void dfs(int p, int len){
    if(visited[p] == true) return;
    visited[p] = true;

    if(result < len){
        result = len;
        endPoint = p;
    }
    for(int i=0; i<node[p].size(); i++){
        dfs(node[p][i].first, len + node[p][i].second);
    }
}
int main(){
    cin >> n;
    for(int i=0; i<n-1; i++){
        int a,b,c;
        cin >> a >> b >> c;
        node[a].push_back(make_pair(b,c));
        node[b].push_back(make_pair(a,c));
    }

    dfs(1,0);

    result = 0;
    memset(visited, false, sizeof(visited));

    dfs(endPoint,0);
    cout << result;
}