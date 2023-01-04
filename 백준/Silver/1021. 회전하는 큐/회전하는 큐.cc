#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main(){
    cin.tie(NULL);
    cin.sync_with_stdio(false);
    deque<int> q;
    int N, M, loc, cnt=0, idx;
    string op;

    cin >> N >> M;
    for(int i=1; i<=N; i++) q.push_back(i);
    while(M--){
        cin >> loc;
        for(int j=0; j< N; j++){
            if(q[j] == loc){
                idx = j;
                break;
            }
        }
        if(idx < q.size()/2 +1 ){
            for(int i=0; i< q.size(); i++){
                if(loc == q.front()){
                    q.pop_front();
                    break;
                } 
                q.push_back(q.front());
                q.pop_front();
                cnt++;
            }
        }
        else{
            for(int i=0; i< q.size(); i++){
                if(loc == q.front()){
                    q.pop_front();
                    break;
                } 
                q.push_front(q.back());
                q.pop_back();
                cnt++;
            }
        }
    }
    cout << cnt <<"\n";
    return 0;
}