// 코드번호: code, 제조일: date, 최대수량: maximum, 현재수량: remain
// val_ext보다 작은 데이터, sort_by 기준 오름차순

import java.util.*;

class Solution {
    public class Node{
        int code, date, maximum, remain;
        
        public Node(int code, int date, int maximum, int remain){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        List<Node> all = new ArrayList<>();
        for(int[] d : data){
            if(check(d, ext, val_ext)){
                all.add(new Node(d[0], d[1], d[2], d[3]));
            }
        }
        
        if(sort_by.equals("code")){
            Collections.sort(all, (a,b) -> a.code - b.code);
        } else if(sort_by.equals("date")){
            Collections.sort(all, (a,b) -> a.date - b.date);
        } else if(sort_by.equals("maximum")){
            Collections.sort(all, (a,b) -> a.maximum - b.maximum);
        } else {
            Collections.sort(all, (a,b) -> a.remain - b.remain);
        }
        
        answer = new int[all.size()][4];
        for(int i=0; i<all.size(); i++){
            Node n = all.get(i);
            answer[i] = new int[]{n.code, n.date, n.maximum, n.remain};
        }
        
        return answer;
    }
    
    public boolean check(int[] data, String ext, int val_ext){
        if(ext.equals("code")){
            if(data[0]<val_ext){
                return true;
            }
        } else if(ext.equals("date")){
            if(data[1]<val_ext){
                return true;
            }
        } else if(ext.equals("maximum")){
            if(data[2]<val_ext){
                return true;
            }
        } else {
            if(data[3]<val_ext){
                return true;
            }
        }
        
        return false;
    }
}