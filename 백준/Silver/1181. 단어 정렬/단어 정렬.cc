#include<iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

bool compare(pair<string,int> a, pair<string,int> b){
    if(a.second != b.second){
        return a.second < b.second;
    }
    else{
        return a.first < b.first;
    }
}

int main() {
    int n;
    cin >> n;

    vector<pair<string, int>> arr;
    for(int i=0; i<n; i++){
        string a;
        cin >> a;
        arr.push_back({a, a.length()});
    }

    sort(arr.begin(), arr.end(), compare);

    for(int i=0; i<n; i++){
        if(arr[i] != arr[i+1])
            cout <<  arr[i].first << "\n";
    }
}   