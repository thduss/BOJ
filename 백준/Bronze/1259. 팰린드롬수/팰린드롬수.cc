#include<iostream>
#include <stack>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    while(true){
        string a, b;
        cin >> a;

        if(a == "0") return 0;

        stack<char> q;
        for(int j=0; j<a.length(); j++){
            q.push(a[j]);
        }

        while(!q.empty()){
            b += q.top();
            q.pop();
        }

        if(a == b) cout << "yes\n";
        else cout << "no\n";

    }
}   