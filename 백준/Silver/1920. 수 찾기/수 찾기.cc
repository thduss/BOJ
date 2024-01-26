#include<iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool binary_search(vector<int>& arr, int high, int low, int target){
    if(low>high){
        return false;
    }
    
    int mid= (high+low)/2;

    if(arr[mid] == target) return true;

    if(arr[mid] > target){
        return binary_search(arr, mid-1, low, target);
    }
    else{
        return binary_search(arr, high, mid+1, target);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;

    vector<int> arr(n);
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }
    sort(arr.begin(),arr.end());

    int m;
    cin >> m;
    while(m--){
        int num;
        cin >> num;

        cout << binary_search(arr, n-1, 0, num) << "\n";

    }

}   