#include <iostream>
#include <cmath>
#include <string>
#include <algorithm>

using namespace std;

bool isPrime(int n) {
    if (n <= 1)
        return false;
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}

int main() {
    int N, primeNum = 0;
    cin >> N;
    int arr[N];
    for (int i = 0; i < N; i++)
        cin >> arr[i];

    for (int i = 0; i < N; i++) {
        if (isPrime(arr[i]))
            primeNum += 1;
    }

    cout << primeNum;

    return 0;
}
