#include<iostream>
#include<vector>
using namespace std;

int arr[50][50];
int index_x[4] = {-1,1,0,0};
int index_y[4] = {0,0,-1,1};
int m, n;

bool dfs(int a, int b){
	if (a < 0 || a >= m || b < 0 || b >= n)
		return false;

	if(arr[a][b]){
        arr[a][b] = 0;
		
		for (int i = 0; i < 4; i++)
			dfs(a + index_x[i], b + index_y[i]);

		return true;
	}

	return false;


}

int main(){
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    
    int t;
    cin >> t;

    while(t--){
        int k, result=0;
        cin >> m >> n >> k;

        for(int i=0; i<k; i++){
            int x, y;
            cin >> x >> y;

            arr[x][y] = 1;
        }
        
        for (int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result += dfs(i,j);
            }
        }

        cout << result << "\n";

        // 초기화
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = 0;
            }
        }
    }
}