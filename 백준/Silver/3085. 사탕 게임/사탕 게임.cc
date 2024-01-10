#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int maxCnt = 0;

void cntRow(char arr[50][50], int n){
    for(int i=0; i<n; i++){
        int cnt = 1;
        for(int j=0; j<n; j++){
            if(arr[j][i] == arr[j+1][i]) cnt++;
            else{
                if(cnt > maxCnt) maxCnt = cnt;
                cnt = 1;
            }
        }
    }
}

void cntColumn(char arr[50][50], int n){
    for(int i=0; i<n; i++){
        int cnt = 1;
        for(int j=0; j<n; j++){
            if(arr[i][j] == arr[i][j+1]) cnt++;
            else{
                if(cnt > maxCnt) maxCnt = cnt;
                cnt = 1;
            }
        }
    }
}

int main() {
    int n;
    cin >> n;
    
    char arr[50][50];
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++)
            cin >> arr[i][j];
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n-1; j++){
            //가로 
            swap(arr[i][j], arr[i][j+1]);
            cntColumn(arr,n);
            cntRow(arr,n);
            swap(arr[i][j+1], arr[i][j]);

            //세로
            swap(arr[j][i], arr[j+1][i]);
            cntColumn(arr,n);
            cntRow(arr,n);
            swap(arr[j+1][i], arr[j][i]);

        }
    }
    cout << maxCnt;
}
