#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int m;
    cin >> m;
    
    int arr[21] = {0,};

    while(m--){
        string oper;
        int x;
        cin >> oper;

        if(oper == "add"){
            cin >> x;
            arr[x] = 1;
        }
        else if(oper == "remove"){
            cin >> x;
            arr[x] =  0;
        }
        else if(oper == "check"){
            cin >> x;
            if(arr[x]) cout << "1\n";
            else cout << "0\n";
        }
        else if(oper == "toggle"){
            cin >> x;
            if(arr[x]) arr[x] = 0;
            else arr[x]=1;
        }
        else if(oper == "all"){
            fill(arr, arr + 21, 1);
        }
        else if(oper == "empty"){
            fill(arr, arr + 21, 0);
        }
    }

    return 0;
}

