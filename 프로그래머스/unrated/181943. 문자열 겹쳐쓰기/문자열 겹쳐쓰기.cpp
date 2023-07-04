#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string overwrite_string, int s) {
    string answer = "";
    int cnt=0;
    for(int i=0; i < my_string.length(); i++){
        if(i>=s && i<overwrite_string.length()+s)
            answer += overwrite_string[cnt++];
        else
            answer += my_string[i];
    }
    
    return answer;
}