#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
using namespace std;

int main(){
    int n;
    cin >> n;

    int arr[n];
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    int b, c;
    cin >> b >> c;

    long long cnt = 0;
    for(int i=0; i<n; i++){
        int people = arr[i];

        people -= min(people,b);
        cnt++;

        if(people != 0){
            //부감독
            int tmp = people/c;

            cnt += tmp;
            people -= tmp*c;

            if(people > 0){
                cnt++;
            }
        }
    }

    cout << cnt;
    
}