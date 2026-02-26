import java.util.*;

class Solution {
    
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    
    public int solution(String[] maps) {
        int answer = 0;
        int x=0,y=0;
        
        // 출발점 찾기
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                char c = maps[i].charAt(j);
                if(c=='S'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        // 레버
        Node middle = bfs(x, y, 'L', maps);
        answer += middle.time;
        System.out.println(middle.x + " " + middle.y + " " + middle.time);
        if(middle.time==-1) return -1;
        
        Node end = bfs(middle.x, middle.y, 'E', maps);
        answer += end.time;
        
        if(end.time==-1) return -1;
        
        return answer;
    }
    
    public static class Node{
        int x, y, time;
        
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    
    private Node bfs(int x, int y, char end, String[] maps){
    
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        queue.add(new Node(x,y,0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            // 종료 조건
            if(maps[cur.x].charAt(cur.y)==end){
                return cur;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                
                if(nx>=maps.length || nx<0 || ny>=maps[0].length() || ny<0){
                    continue;
                }
                    
                if(maps[nx].charAt(ny)=='X' || visited[nx][ny]){
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, cur.time+1));
            }
        }
        
        return new Node(x,y,-1);
    }
}