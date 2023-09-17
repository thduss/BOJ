#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    string answer;
    
    string a1, a2;
    a1 = to_string(a);
    a1 += to_string(b); 
    a2 = to_string(b);
    a2 += to_string(a);
    
    answer = a2;
    if(stoi(a1) > stoi(a2)) answer = a1;
    
    return stoi(answer);
}