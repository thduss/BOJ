#include <iostream>
using namespace std;

int maxi=0;
int K,N, line[10001], ans;
long long low, mid, high;

int main(){
    ios_base::sync_with_stdio(0);
	cin.tie(0);

    cin >> K >> N;

	for(int i=0; i<K; i++){
		cin >> line[i];
		if(maxi<line[i]) maxi = line[i];
	}

	low = 1;
	high = maxi;
	while(low <= high){
		mid = (low + high) / 2;
		int cnt=0;
		for (int i = 0; i < K; i++) cnt += line[i] / mid;
		if (cnt >= N) {
			low = mid + 1;
			if (ans < mid) ans = mid;
		}
		else {// (cnt < N)
			high = mid - 1;
		}
	}
	cout << ans;
}