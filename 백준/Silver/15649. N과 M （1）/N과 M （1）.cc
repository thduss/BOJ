#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int n, m;
bool visited[9] = {0,};
int arr[9] = {0, };

void  dfs(int node){
    if(node == m){
        for(int i=0; i<m; i++) cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    for(int i=1; i<=n; i++){
        if( !visited[i]){
            visited[i] = true;
            arr[node] = i;
            dfs(node+1);
            visited[i] = false;
        }
    }
}
int main() {
    cin >> n >> m;
    
    dfs(0);
}