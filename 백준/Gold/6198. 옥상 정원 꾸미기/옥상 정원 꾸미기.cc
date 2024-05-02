#include <iostream>
#include <string>
#include <cstdio>
#include <stack>

using namespace std;

int main(){
    int n;
    cin >> n;

    int arr[n];
    for(int i=0; i<n; i++)
        cin >> arr[i];

    stack<int> st;
    long long count=0;
    st.push(arr[0]);
    for(int i=1; i<n; i++){
        while(!st.empty() && st.top() <= arr[i]){
            st.pop();
        }
        count += st.size();
        st.push(arr[i]);
    }

    cout << count;
}