#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main(){
    int n;
    cin >> n;

    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0; i<n; i++){
        int a;
        cin >> a;
        pq.push(a);
    }

    for(int i=0; i<n; i++){
        cout << pq.top() << "\n";
        pq.pop();
    }
    
    
}