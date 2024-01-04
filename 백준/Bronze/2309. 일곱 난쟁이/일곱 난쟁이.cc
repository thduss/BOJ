#include <iostream>
#include <cmath>
#include <string>
#include<algorithm>

using namespace std;

int main()
{   
    int arr[9], sol[7]= {0, };
    for(int i=0; i<9; i++){
        cin >> arr[i];
    }

    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            int sum = 0;
            
            if(i==j) j+=1;
            
            int num=9;
            while(num--){
                if(num != i && num != j){
                    sum += arr[num];
                    if(sum > 100) break;
                }
            }

            if(sum == 100){
                int num=0;
                for(int k=0; k<9; k++){
                    if(k != i && k != j) sol[num++] = arr[k];
                } 
                break;
            }
        }
    }
    
    // 오름차순 정렬
    sort(sol, sol+7);

    for(int i=0; i<7; i++) cout << sol[i] << endl;
}   
