#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, ts, p;
    cin >> n >> ts >> p;

    vector<int> arr(n);
    for(int i=0; i<n; i++) cin >> arr[i];

    //랭킹 구하기
    int rank=1, cnt=0;
    for(int i=0; i<n; i++){
        if(arr[i] > ts){
            rank++;
        }
        else if(arr[i] == ts){
            rank = rank;
        }
        else{
            break;
        }
        cnt++;
    }

    if(cnt == p){
        rank = -1;
    }
    if(n==0){
        rank=1;
    }

    cout << rank;

    return 0;

}