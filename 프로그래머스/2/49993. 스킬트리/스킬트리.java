class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String word : skill_trees){
            int idx=0;
            boolean isTrue = true;
            
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                
                if(skill.contains(c+"")){
                    if(skill.charAt(idx)==c){
                        idx++;
                    } else {
                        isTrue = false;
                        break;
                    }
                } 
            }
            
            if(isTrue) answer++;
        }
        
        return answer;
    }
}