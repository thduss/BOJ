#include <iostream>
#include <cmath>

using namespace std;

int prime[100001]; // 0: 초기, 1: 소수, 2: 소수X

int main()
{   
    int M, N;
    cin >> N >> M;
    
    //에라토스테네스의 체
    for(int i=2; i<=10000; i++){
        if(prime[i] == 2) continue;
        else prime[i] = 1;
        for(int j=i+i; j<=10000; j+=i){
            prime[j]=2;
        }
    }

    int minNum=10000;
    int sum = 0;

    for(int i=N; i<=M; i++){
        if(prime[i] == 1){
            sum += i;
            minNum = min(minNum, i);
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
