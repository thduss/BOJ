#include<iostream>
#include<stack>
using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    string str;
    cin >> str;

    stack<char> q;

    int cnt = 0;
    for(int i=0; i<str.length(); i++){
        if(str[i] == '('){
            q.push(str[i]);
        }
        else{
            if(str[i]==')' && str[i-1] == '('){
                q.pop();
                cnt += q.size(); // 겹친 막대기 수
            }
            else{
                q.pop();
                cnt++;
            }
        }
    }

    cout << cnt;
}