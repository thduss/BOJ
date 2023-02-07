#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

bool compare (string a, string b){
	if (a.length() < b.length()) {
		return 1;
	}
	else if (b.length() < a.length()) {
		return 0;
	}
	else {
		return a < b;
	}
}
int main(){
    ios_base::sync_with_stdio(0);
	cin.tie(0);

    int N;
    cin >> N;
    
    string arr[100000];
    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    sort(arr, arr+N, compare);

    for(int i=0; i<N; i++){
        if (i > 0 && arr[i] == arr[i - 1]) continue;
        cout << arr[i] << "\n";
    }
    return 0;

}