#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, cnt=2, i=1;
    cin >> n;
    
    if(n==1) cout << 1;
    else{
       while (n >= cnt)
       {
            cnt += 6*i;
            i++;
       }
       cout << i;
        
    }
    

    return 0;
}
