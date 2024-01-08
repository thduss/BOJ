#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, cnt=0;
    cin >> n;
    
    string word;
    while (n--)
    {
        cin >> word;

        char arr[word.size()]; // 알파벳 담을 배열
        int index=0;
        bool isTrue = true;

        arr[index] = word[0];
        for(int i=1; i<word.size(); i++){
            if(arr[index] != word[i]){
                for(int j=0; j<index; j++){
                    if(arr[j] == word[i]){ 
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue == true){
                    index++;
                    arr[index] = word[i];
                }
            }
        } 

        if(isTrue == true) cnt+=1;
    }
    cout << cnt;
}