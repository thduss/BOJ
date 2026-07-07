class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 3 이상 15 이하
        // 소문자, 숫자, -, _, . 
        // .처음과 끝 X, 연속 사용 X
        
        // step1
        new_id = new_id.toLowerCase();
        
        // step2 & 3
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<new_id.length(); i++){
            if(sb.length()>0 && new_id.charAt(i)=='.' && sb.charAt(sb.length()-1)=='.'){
                continue;
            }
            
            if(check(new_id.charAt(i))){
                sb.append(new_id.charAt(i));
            }
        }
        
        // step4 
        if(sb.charAt(0)=='.'){
            sb.delete(0,1);
        } 
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='.'){
            sb.delete(sb.length()-1, sb.length());
        }
        
        // step5
        if(sb.length()==0){
            sb.append("a");
        }
        
        // step6
        if(sb.length()>15){
            sb.delete(15, sb.length());
        }
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='.'){
            sb.delete(sb.length()-1, sb.length());
        }
        
        // step7
        if(sb.length()<3){
            while(sb.length()<3){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
    
    public static boolean check(char c){
        if(Character.isAlphabetic(c) || Character.isDigit(c)){
            return true;
        }
        
        char[] arr = {'_', '-', '.'};
        for(char a : arr){
            if(c==a) return true;
        }
        
        return false;
    }
}