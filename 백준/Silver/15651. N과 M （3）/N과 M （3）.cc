#include <iostream>
using namespace std;

int n,m, arr[9]={0,};
bool visited[9]={0,};

void dfs(int start){
    if(start == m){
        for(int i=0; i<m; i++) cout << arr[i] << " ";
        cout <<"\n";
        return;
    }
    for(int i=1; i<=n; i++){
        visited[i] = true;
        arr[start] = i;
        dfs(start+1);
        visited[i] = false; //i에 대해 m까지 사용했으니 다시 false로
    }
}
int main(){
    cin >> n >> m;
    dfs(0);
}