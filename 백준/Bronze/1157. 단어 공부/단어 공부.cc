#include <iostream>
#include <algorithm>
#include <string>
#include <map>

using namespace std;

int main() {
    string word;
    cin >> word;

    map<char, int> m;
    for(int i=0; i<word.length(); i++){
        if(islower(word[i])){
            word[i] = toupper(word[i]);
        }
        char tmp = word[i];
        if(m.find(tmp) == m.end()){
            //존재하지 않는다면
            m.insert(make_pair(tmp, 1));
        }
        else{
            m.find(tmp)->second += 1;
        } 
    }

    //second값 가장 큰 값 찾기
    map<char, int>::iterator iter;
    map<char, int>::iterator max_iter = m.begin();

    for(iter = m.begin(); iter!=m.end(); iter++){
        if(max_iter->second <= iter->second) max_iter = iter;
    }
    
    //max_iter과 사용 횟수가 같은 경우 찾기
    for(iter=m.begin(); iter != m.end(); iter++){
        if(max_iter->second == iter->second && max_iter->first != iter->first){
            cout << "?";
            return 0;
        }
    }

    cout << max_iter->first;
    return 0;
}