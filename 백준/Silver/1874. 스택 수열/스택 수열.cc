#include <iostream>
#include <stack>
using namespace std;

int main(){
    stack<int> s;
    int n;
    int i=1; // 스택 마지막 값
    string op;

    cin >> n;
    while(n--) 
    {
        int num; 
        cin >> num;
        if(num >= i){
            while(num >= i){
                s.push(i);
                op += '+';
                i++;
            }
            s.pop();
            op += '-';
        }
        else{
            if(s.top() < num){
                cout << "NO" << endl;
                return 0;
            }
            else{
                s.pop();
                op += '-';
            }
        }
    }
    for(int j=0; j<op.length(); j++){
        cout << op[j] << "\n";
    }
    return 0;
}