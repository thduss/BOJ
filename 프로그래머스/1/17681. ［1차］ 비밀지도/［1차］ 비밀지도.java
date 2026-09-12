/*
- 공백 혹은 벽
*/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[] sum = new int[n];
        for(int i=0; i<n; i++){
            sum[i] = arr1[i] | arr2[i];
        }
        
        for(int i=0; i<n; i++){
            String str = Integer.toBinaryString(sum[i]);
            
            while(str.length()<n){
                str = "0" + str;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}