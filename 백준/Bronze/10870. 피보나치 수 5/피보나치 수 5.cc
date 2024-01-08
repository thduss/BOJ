#include <iostream>
#include <algorithm>

using namespace std;

int fibo(int n){
    if(n==0 || n==1){
        if(n==0) return 0;
        else return 1;
    }
    else{
        int result = fibo(n-1) + fibo(n-2);
        return result;
    }
    return 0;
}
int main() {
    int n;
    cin >> n;

    cout << fibo(n);
}