#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int maxi=0, ans;
vector<int> vec;

int main(){
    long long N, M, sum;
	cin >> N >> M;

	for(int i=0; i<N; i++){
		int a;
		cin >> a;
		vec.push_back(a);
		if(a >= maxi) maxi = a;
	}

	int left = 0;
	int right = maxi;
	
	while(left <= right){
		int mid = (left + right) / 2;
		sum = 0;
		for(int i=0; i<N; i++){
			if(mid < vec[i]) sum += vec[i]-mid;
		}
		if(sum >= M){
			if(ans<mid){
				ans = mid;
			}
			left = mid + 1;
		}
		else{
			right = mid - 1;
		}
	}
	cout << ans;
}