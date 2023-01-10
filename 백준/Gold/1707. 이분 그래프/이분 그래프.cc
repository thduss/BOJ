#include <iostream>
#include <vector>
#include <string.h>
#include <cstring>
using namespace std;

#define red 2
#define blue 3

int K, V, E; // testcase, 정점 수, 간선 수
int visited[20001]; // 방문 확인 행렬
vector<int> vect[20001]; // 인접 리스트

void dfs(int start){
    //방문 안 한 점
    if(visited[start] == 0) visited[start] = red;

    //연결된 점
    for(int i=0; i< vect[start].size(); i++){
        int idx = vect[start][i];
        if(visited[idx] == 0){
            if(visited[start] == red) visited[idx]=blue;
            else if(visited[start] == blue) visited[idx]=red;
            dfs(idx);
        }
    }
}
int check(){
    //인접한 두 점의 색이 같으면 이분 그래프 X
    for(int i=1; i<=V; i++){
        for(int j=0; j< vect[i].size(); j++){
            int idx = vect[i][j];
            if(visited[i] == visited[idx]) return false;
        }
    }
    return true;

}

int main(){
    cin >> K;
    while(K--){
        cin >> V >> E;
        for(int i=0; i<E; i++){
            int u,v; 
            cin >> u >> v;
            vect[u].push_back(v);
            vect[v].push_back(u);
        }

        for(int i=1;i <= V; i++) {
            if(visited[i] == 0) dfs(i);
        }

        if(check() == 0) cout << "NO\n";
        else cout << "YES\n";

        memset(visited,0,sizeof(visited));
        memset(vect,0,sizeof(vect));
    }

    return 0;
}