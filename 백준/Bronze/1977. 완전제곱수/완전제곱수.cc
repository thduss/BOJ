#include <iostream>
#include <cmath>

using namespace std;

int main()
{   
    int n, m;
    cin >> n >> m;

    int sum=0;
    int N = sqrt(n);
    int minNum=10000;

    for(int i=N; i<=sqrt(m); i++){
        int I = i*i;
        if(I >= n){
            sum += (I);
            minNum = min(minNum , I);
        }
    }

    if(sum != 0){
        cout << sum << endl;
        cout << minNum;
    }
    else{
        cout << "-1";
    }
}
