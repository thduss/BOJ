#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int dayCnt(int x){
    if(x == 2) return 28;
    else if(x == 4|| x==6 || x==9 || x==11) return 30;
    else return 31;
}
int main() {
    int x, y;
    cin >> x >> y;
    
    int sum=y;
    for(int i=1; i<x; i++){
        sum += dayCnt(i);
    }

    int day = sum % 7;
    string weekend[8] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    
    cout << weekend[day];

    return 0;
}