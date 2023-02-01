#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    int n,k,w[101],v[101], d[101][100001]; // 물품 수, 가능 무게, 각 물건 무게, 물건 가치, 가방용량
    cin >> n >> k;

    for(int i=1; i<=n; i++){
        cin >> w[i] >> v[i];
    }

    for(int i=1; i<=n; i++){
		for (int j = 1; j <= k; j++){ 
			 if (j - w[i] >= 0) d[i][j] = max(d[i - 1][j], d[i - 1][j - w[i]] + v[i]);
			 else d[i][j] = d[i - 1][j];
		}
    }
    cout << d[n][k] << "\n";

    return 0;
}
