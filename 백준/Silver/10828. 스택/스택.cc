#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    stack<int> st;
    
    while (n--){
        string op;
        cin >> op;
        if(op == "push"){
            int num;
            cin >> num;
            st.push(num);
        }
        else if(op == "pop"){
            if(st.empty()){
                cout << "-1\n";
            }
            else{
                cout << st.top() << "\n";
                st.pop();   
            }
        }
        else if(op == "size"){
            cout << st.size() << "\n";
        }
        else if(op == "empty"){
            if(st.empty()){
                cout << "1\n";
            }
            else{
                cout << "0\n";
            }
        }
        else if(op == "top"){
            if(st.empty()){
                cout << "-1\n";
            }
            else{
                cout << st.top() << "\n";
            }
        }
    }
    
    return 0;
}
