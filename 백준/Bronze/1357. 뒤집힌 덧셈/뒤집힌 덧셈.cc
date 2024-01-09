#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int rev(int x){
    string str_x = to_string(x);
    string new_x;
    for(int i=str_x.length()-1; i>=0; i--){
        new_x += str_x[i];
    }
    x = stoi(new_x);
    return x;
}
int main() {
    int x, y;
    cin >> x >> y;
    cout << rev(rev(x) + rev(y));
    
    return 0;
}