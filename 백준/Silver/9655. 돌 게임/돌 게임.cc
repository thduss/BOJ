#include <iostream>
#include <algorithm>

using namespace std;

int main() {
   int n, cnt=0;
   cin >> n;

    while(n>3){
        n-=3;
        cnt+=1;
    }
    while(n>0){
        n-=1;
        cnt++;
    }

    if(cnt%2 == 0) cout << "CY";
    else cout << "SK";

    return 0;
}