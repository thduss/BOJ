#include <iostream>
#include <string>
#include <cstdio>
#include <stack>

using namespace std;

int main(){
    int n;
    cin >> n;

    int arr[n], ans[1000001]={0,};
    for(int i=0; i<n; i++)
        cin >> arr[i];

    stack<int> st;
    for(int i=0; i<n; i++){
        while(!st.empty() && arr[st.top()] < arr[i]) {
            ans[st.top()] = arr[i];
            st.pop();
        }
        st.push(i);
    }

    while(!st.empty()){
        ans[st.top()] = -1;
        st.pop();
    }

    for(int i=0; i<n; i++)
        cout << ans[i] << " ";
}