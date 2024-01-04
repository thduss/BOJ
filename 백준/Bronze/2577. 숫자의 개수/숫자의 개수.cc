#include <iostream>
#include <cmath>
#include <string>

using namespace std;

int main()
{   
    int A, B, C;
    cin >> A >> B >> C;

    A = A*B*C;
    string st = to_string(A);
    int arr[10] = {0, };
    
    for(int i=0; i<st.size(); i++){
        for(int j=9; j>=0; j--){
            char num = j + 48;
            if(st[i] == num){
                arr[j] +=1;
                break;
            }
        }
    }

    for(int i=0; i<10; i++){
        cout << arr[i] << endl;
    }
}   
