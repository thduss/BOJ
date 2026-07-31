import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        // min값 : lx, ly
        // max값 : rx, ry
        int lx = wallpaper.length, ly = wallpaper[0].length(), rx = 0, ry = 0;
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j)=='#'){
                    if(lx>i){
                        lx = i;
                    } 
                    
                    if(ly>j){
                        ly = j;
                    }
                    
                    if(rx<i){
                        rx = i;
                    } 
                    
                    if(ry<j){
                        ry = j;
                    }
                }
            }
        }
        answer = new int[]{lx,ly,rx+1,ry+1};
        return answer;
    }
}