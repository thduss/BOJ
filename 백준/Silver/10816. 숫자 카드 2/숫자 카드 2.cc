#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    
    int arr[n+1];
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    sort(arr, arr+n);

    int m;
    cin >> m;

    while(m--){
        int card;
        cin >> card;

        cout << upper_bound(arr, arr+n, card) - lower_bound(arr,arr+n, card) << " ";
    }
    return 0;
}
