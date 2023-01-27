#include <iostream>
#include <string.h>
#include <cmath>
using namespace std;

int main(){
    int tcase;
    cin >> tcase;

    while(tcase--){
        string S;
        long long N,T,L, result,cal=0;

        cin >> S >> N >> T >> L;

        if(S == "O(N)"){
            cal = T * N;
            if(cal <= (L*100000000))  cout << "May Pass.\n";
            else cout << "TLE!\n"; 
        }
        else if(S == "O(N^2)"){
            if(N >= 31623) cout << "TLE!\n"; 
            else{
                cal = T*(N*N);
                if(cal <= (L*100000000))  cout << "May Pass.\n";
                else cout << "TLE!\n"; 
            }
        } 
        else if(S == "O(N!)"){
            if(N >= 13) cout << "TLE!\n";
            else{
                cal = T;
                for (long long i = 1; i <= N; i++){
                    cal *= i;
                }
                if(cal <= (L*100000000)) cout << "May Pass.\n";
                else cout << "TLE!\n"; 
            }
        }
        else if(S == "O(N^3)"){
            if(N >= 1001) cout << "TLE!\n"; 
            else{
                cal = T*N*N*N;
                if(cal <= (L*100000000))  cout << "May Pass.\n";
                else cout << "TLE!\n"; 
            }
        } 
        else if(S == "O(2^N)"){
            if(N>=30) cout << "TLE!\n"; 
            else{
                cal = (long long)pow(2, N) * T;
                if(cal <= (L*100000000)) cout << "May Pass.\n";
                else cout << "TLE!\n";
            }
        }
    }
}