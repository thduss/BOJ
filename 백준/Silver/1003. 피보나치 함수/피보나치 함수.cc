#include<iostream>
#include<queue>
using namespace std;

int main(){
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    
    int t;
    cin >> t;

    while(t--){
        int n;
        cin >> n;

        int zero[41]={1,0};
        int one[41]={0,1};
        for(int i=2; i<=n; i++){
            one[i] = one[i-1] + one[i-2];
            zero[i] = zero[i-1] + zero[i-2];
        }

        cout << zero[n] << " " << one[n] << "\n";
    }
    
}