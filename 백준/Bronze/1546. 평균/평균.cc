#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;

    double maxNum=0, arr[1001];
    for(int i=0; i<n; i++){
        cin >> arr[i];
        maxNum = max(maxNum, arr[i]);
    }

    double sum = 0.0;
    for(int i=0; i<n; i++){
        sum += ((arr[i]/maxNum)*100);

    }

    cout << sum/n;
}