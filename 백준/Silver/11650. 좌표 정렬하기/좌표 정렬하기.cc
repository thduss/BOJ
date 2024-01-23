#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(const pair<int,int>& a, const pair<int,int>& b){
    if(a.first == b.first){
        return a.second <b.second;
    }
    return a.first<b.first;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<pair<int,int>> v;
    for(int i=0; i<n; i++){
        int a, b;
        cin >> a >> b;

        v.push_back(make_pair(a,b));
    }
    
    sort(v.begin(), v.end(), compare);

    for(int i=0; i<n; i++) cout << v[i].first << " " << v[i].second << "\n";

    return 0;
}
