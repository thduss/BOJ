#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    long long s;
    cin >> s;

    long long num=1, sum=0, n=0;
    while (true)
    {   
        sum += num;
        if(sum > s){
            num--;
            break;
        }
        num++;
    }

    cout << num;
}
