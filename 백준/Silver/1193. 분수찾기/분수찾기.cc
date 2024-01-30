#include<iostream>
using namespace std;

int main(){
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    
    int num;
    cin >> num;

    int cnt=0;
    for(int i=1; i<=num; i++){
        if(i%2==0){
            int tmp=i;
            for(int j=1; j<=i; j++){
                cnt++;
                if(num==cnt){
                    cout << j << "/" << tmp << "\n";
                    return 0;
                }
                tmp--;
            }
        }
        else{
            int tmp=i;
            for(int j=1; j<=i; j++){
                cnt++;
                if(num==cnt){
                    cout << tmp << "/" << j << "\n";
                    return 0;
                }
                tmp--;
            }
        }
    }
}