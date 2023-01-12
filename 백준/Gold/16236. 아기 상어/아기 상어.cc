#include <iostream>
#include <queue>
#include <cstring>
#include <vector>
using namespace std;

int N, map[21][21], dist[21][21], currentLevel, cur_x, cur_y, result;
bool visited[21][21];
int dx[] = {0, 0, 1, -1};
int dy[] = {-1, 1, 0, 0};

struct info{
    int x,y;
};

void bfs(){
    queue <info> q;
    visited[cur_x][cur_y] = true;
    q.push({cur_x, cur_y}); 
    dist[cur_x][cur_y] = 0;

    while(!q.empty()){
        //큐에서 가장 앞에 있는 객체 꺼내기
        info cur = q.front();
        q.pop();
        int x = cur.x;
        int y = cur.y;

        //4방향 탐색
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 맵의 범위 안에 있고, 방문한 적이 없다. 
            //그리고 공간에 있는게 0 이거나 현재 레벨보다 작거나 같아야 이동 가능  
            if((nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) && (map[nx][ny] == 0 || map[nx][ny] <= currentLevel)){
                q.push({nx, ny});
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

    }

}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    currentLevel = 2;
   
   for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){
        cin >> map[i][j];

        if(map[i][j]==9){
            cur_x = i;
            cur_y = j;
            map[i][j] =0;
        }
    }
   }

   int kill_cnt;
   while(true){
    memset(visited, 0, sizeof(visited));
    memset(dist, 0, sizeof(dist));
    bfs();
    
    int minDist = 987987987, minDist_x, minDist_y; //최소 거리
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(map[i][j] != 0 && visited[i][j] && map[i][j] < currentLevel){  
                    if(minDist > dist[i][j]){
                        minDist = dist[i][j];
                        minDist_x = i;
                        minDist_y = j;
                    }
            }
        }
    }
   
 
    if(minDist == 987987987) break; // 잡아 먹을 수 있는 물고기가 없다고 판단

    kill_cnt++; //break로 빠져나오지 않고, 물고기를 잡아 먹었다면 잡아 먹은 물고기 수 Kill_cnt++
    result += dist[minDist_x][minDist_y]; // 결과 누적 합 
    map[minDist_x][minDist_y] = 0; //물고기를 앲애준다.

    cur_y = minDist_y; //현재 위치를 갱신해준다. 
    cur_x = minDist_x;
 
    if(kill_cnt == currentLevel){ //현재 아기 상어 레벨만큼 물고기를 잡아 먹었다면 
            currentLevel++; //현재 레벨을 up 해준다.
            kill_cnt = 0; //잡아 먹은 물고기 수를 초기화 해준다. 
    }
   }

    cout<<result<<"\n";

    return 0;
}