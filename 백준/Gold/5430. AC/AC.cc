#include <iostream>
#include <deque>
using namespace std;

int main(){
    int T; // testCase
    deque<int> q;
    
    cin >> T;
    while(T--){
        string op, arr;
        int n; // arrNum;
        cin >> op >> n >> arr;

        //arrNum 만들기
        string tmp;
        for(int i = 0; i< arr.length(); i++){
            if(arr[i]=='[') continue;
            else if('0'<= arr[i] && '9' >= arr[i]) tmp += arr[i];
            else if(arr[i] == ',' || arr[i] == ']'){
                if(!tmp.empty()){
                    q.push_back(stoi(tmp));
                    tmp.clear();
                }
            }
        }
        //op 수행하기
        bool left = true; // 뒤집혀있지 않으면 true
        bool print = true; // error 아닐때 true
        for(int i=0; i<op.length(); i++){
            if(op[i] == 'R'){
                left = !left;
            }
            else{
                if(q.empty()){
                    print = false;
                    cout << "error\n";
                    break;
                }
                else {
                    if(left == true) q.pop_front();
                    else q.pop_back();
                }
            }
        }
        //출력
        if(print == true){
            if(left == true){
                cout<< "[";
                while(!q.empty()){
                    cout << q.front();
                    q.pop_front();
                    if(!q.empty()) cout << ",";                    
                }
                cout << "]\n";
            }
            else{
            cout<< "[";                       
            while(!q.empty()){
                cout << q.back();
                q.pop_back();
                    if(!q.empty()) cout << ",";
                }
                cout << "]\n";
            }
        }
    }
    return 0;
}