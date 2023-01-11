#include <iostream>
#include <queue>
#include <string>
#include <cstring>
using namespace std;

void bfs(int A, int B){
    queue<pair<int, string> > q;
    bool visited[100000] = {0,};
    q.push(make_pair(A,""));
    visited[A]=1;

    while(!q.empty()){
        int x = q.front().first;
        string y = q.front().second;
        q.pop();

        if(x == B){
            cout << y << "\n";
            return;
        }
        int D = (x*2) % 10000;
        if(!visited[D]){
            visited[D]=1;
            q.push(make_pair(D, y+"D"));
        }
        int S = x-1;
        if(S < 0) S = 9999;
        if(!visited[S]){
            visited[S]=1;
            q.push(make_pair(S, y+"S"));;
        }
        int L = (x%1000)*10 + x/1000;
        if(!visited[L]){
            visited[L]=1;
            q.push(make_pair(L, y+"L"));
        }
        int R = x/10 + (x%10)*1000;
        if(!visited[R]){
            visited[R]=1;
            q.push(make_pair(R, y+"R"));
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
   
    while(T--){
        int A,B; // 초기값, 결과값
        cin >> A >> B;
        bfs(A,B);
    }

    return 0;
}