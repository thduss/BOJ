
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        int day = b;
        for(int i=0; i<a-1; i++){
            day += month[i];
        }
        
        String[] eng = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int idx = day%7;
        answer = eng[idx];
        
        return answer;
    }
}