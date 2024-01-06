#include <iostream>
#include <cmath>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    int arr[10001], index= 1;
    for(int i=1; i<=45; i++){
        for(int j=1; j<=i; j++){
            if(index <= 10000){
                arr[index] = i;
                index += 1;
            }
        } 
    }

    int A, B, sum=0;
    cin >> A >> B;

    for(; B>=A; B--) sum += arr[B];
    cout << sum;

}
