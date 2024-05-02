#include <iostream>
#include <stack>

using namespace std;

void R(bool& is_reverse){
    is_reverse = !is_reverse;
}
bool D(deque<int>& dq, bool& is_reverse){
    if(!dq.empty()){
        if(is_reverse){
            dq.pop_back();
        }else{
            dq.pop_front();
        }
        return true;
    }
    else{
        return false;
    }
}

int main(){
    int t;
    cin >> t;

    while(t--){
        string command, list;
        int n;
        cin >> command >> n >> list;

        deque<int> dq;

        string tmp;
        for(char ch : list){
            if(isdigit(ch)){
                tmp += ch;
            }
            else if (ch == ',' || ch == ']') {
                if(!tmp.empty()){
                    dq.push_back(stoi(tmp));
                    tmp.clear();
                }
            }
        }

        bool flag = false, is_reverse= false;
        for(int i=0; i<command.size(); i++){
            if(command[i] == 'R'){
                R(is_reverse);
            }else{
                if(!D(dq, is_reverse)){
                    cout << "error\n";
                    flag = true;
                    break;
                }
            }
        }
        if(!flag){
            int cnt = dq.size();
            cout << "[";
            if(!is_reverse){
                for(int i = 0; i < cnt; i++){
                    cout << dq.front();
                    dq.pop_front();
                    if (i != cnt - 1) cout << ",";
                }
            }
            else{
                for(int i = 0; i < cnt; i++){
                    cout << dq.back();
                    dq.pop_back();
                    if (i != cnt - 1) cout << ",";
                }
            }
            cout << "]\n";
        }
    }

}