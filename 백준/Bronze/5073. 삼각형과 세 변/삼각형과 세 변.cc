#include <iostream>
#include <algorithm>

using namespace std;

int main() {
   
    while (true)
    {
        int arr[3];
        cin >> arr[0] >> arr[1] >> arr[2];

        if(arr[0] == arr[1] && arr[1] == arr[2]){
            if(arr[0] == 0) 
                break;
            else 
                cout << "Equilateral" << "\n";
        }
        else{
            sort(arr, arr+3);
            if(arr[0] + arr[1] <= arr[2]) cout << "Invalid" << "\n";
            else{
                if(arr[0] == arr[1] || arr[1] == arr[2]) cout << "Isosceles" << "\n";
                else cout << "Scalene" << "\n";
            }
        }

    }
    return 0;
}

