#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    queue<int> q;
    
    while (n--){
        string op;
        cin >> op;
        if(op == "push"){
            int num;
            cin >> num;
            q.push(num);
        }
        else if(op == "pop"){
            if(q.empty()){
                cout << "-1\n";
            }
            else{
                cout << q.front() << "\n";
                q.pop();   
            }
        }
        else if(op == "size"){
            cout << q.size() << "\n";
        }
        else if(op == "empty"){
            if(q.empty()){
                cout << "1\n";
            }
            else{
                cout << "0\n";
            }
        }
        else if(op == "front"){
            if(q.empty()){
                cout << "-1\n";
            }
            else{
                cout << q.front() << "\n";
            }
        }
        else if(op == "back"){
            if(q.empty()){
                cout << "-1\n";
            }
            else{
                cout << q.back() << "\n";
            }
        }
    }
    
    return 0;
}
