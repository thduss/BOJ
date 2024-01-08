#include <iostream>
#include <cmath>
#include <map>

using namespace std;

int main()
{   
    map<int, int> m;
    int maxNum = 0;
    int index = 0;

    for(int i=1; i<=9; i++){
        int value;
        cin >> value;
        m.insert(pair(i, value));
    }

    for(int i=1; i<=9; i++){
        maxNum = max(maxNum, m[i]);
        if(maxNum == m[i]){
            index = i;
        }
    }

    cout << maxNum << endl << index;
}