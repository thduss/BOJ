#include <iostream>
using namespace std;

int N, M, width, maxWidth, visited[500][500]; // N가로 M세로 cnt그림개수
char map[500][500];
int dir[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};

void dfs(int n, int m){
    visited[n][m] = true;
    width++;

    for(int i=0; i<4; i++){
        int nN = n + dir[i][0];
        int nM = m + dir[i][1];
        if(visited[nN][nM]) continue;
        if(nN >= 0 && nN < N && nM < M && nM >=0 && map[nN][nM] == '1') dfs(nN, nM);
    }
}

int main(){
    cin >> N >> M;
    
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++) cin >> map[i][j];
    }
    
    int cnt=0;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(!visited[i][j] && map[i][j] == '1'){
                cnt++;
                width = 0;
                dfs(i,j);
                maxWidth = max(maxWidth, width);
            }
        }
    }
    cout << cnt << "\n";
    cout << maxWidth;
    return 0;
}