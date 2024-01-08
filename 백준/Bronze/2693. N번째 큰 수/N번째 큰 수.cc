#include <iostream>
#include <cmath>
#include <string>
#include<algorithm>

using namespace std;

int main()
{   
    int T;
    cin >> T;
    while (T--)
    {
        int arr[10]={0,};
        for(int i=0; i<10; i++) cin >> arr[i];

        sort(arr, arr+10);

        cout << arr[7] << endl;
    }
    
} 