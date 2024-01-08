#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<pair<int,int>> arr;
    int rank=1;
    for(int i=0; i<n; i++){
        int x, y;
        cin >> x >> y;
        arr.push_back(make_pair(x,y));
    }

    for(int i=0; i<n; i++){
        for(int j = 0; j < n; j++)
            if(arr[i].first < arr[j].first && arr[i].second < arr[j].second)
                rank++;
        cout << rank << ' ';
        rank = 1;
    }

}