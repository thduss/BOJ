#include <iostream>
#include <stack>
using namespace std;

int main(){
    int N, An, ans[10000000];
    stack<int> s;
    cin >> N;
    int arr[N];
    for(int i = 0; i<N;i++) cin >> arr[i];

    //오큰수 구하기
   for(int i = N-1; i>=0; i--){
        while(!s.empty() && s.top() <= arr[i]){
            s.pop();
        }
        if(s.empty()) ans[i]= -1;
        else ans[i]= s.top();
        
        s.push(arr[i]);
    }
    for(int i=0; i<N; i++) cout << ans[i] << " ";

    return 0;
}