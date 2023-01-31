#include <iostream>
#include <queue>
using namespace std;

int n, x;
priority_queue<int, vector<int> > pq; // 최대힙

int main(){
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n;
    while(n--){
        cin >> x;
        if(pq.empty() && x == 0){
            cout << "0\n";
        }
        else if(x == 0){
            cout << pq.top() << "\n";
            pq.pop();
        }
        else{
            pq.push(x);
        }
    }
    return 0;
}