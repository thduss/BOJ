import java.util.*;

class Solution {
    
    private static class Time implements Comparable<Time> {
        int h, m;
        
        public Time(int h, int m){
            this.h = h;
            this.m = m;
        }
        
        // 시, 분 오름차순
        @Override
        public int compareTo(Time o){
            if(this.h == o.h){
                return this.m - o.m; // 분 오름차순
            }
            return this.h - o.h; // 시 오름차순
        }
            
        public void addMinutes(int t){
            this.m += t;
            if(this.m >= 60){
                this.h += (this.m / 60);
                this.m %= 60;
            }
        }

        public void minusOneMinute(){
            this.m -= 1;

            if(this.m < 0){
                this.h -= 1;
                this.m += 60;
            }
        }

        public String toString(){
            return String.format("%02d:%02d", this.h, this.m);
        }

        public Time copy(){
            return new Time(this.h, this.m);
        }
    }

    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        List<Time> list = new ArrayList<>();
        
        for(int i=0; i<timetable.length; i++){
            String[] arr = timetable[i].split(":");
            
            int hour = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);
            
            list.add(new Time(hour, min));
        }
        
        // list 정렬
        Collections.sort(list);
        
        Time bus = new Time(9,0);
        Time cornTime = null;
        int idx=0;
        for(int i=0; i<n; i++){
            int curCrew = 0;
            
            // 버스 자리가 남았고, 대기열에 크루가 있고, 크루 도착시간 <= 버스 도착시간
            while(curCrew < m && idx < list.size()){
                if(list.get(idx).compareTo(bus)<=0){
                    curCrew++;
                    idx++;
                } else {
                    break;
                }
            }
            
            // 마지막 버스일 때
            if(i==n-1){
                if(curCrew==m){
                    // 꽉 찼으면 1분 일찍
                    cornTime = list.get(idx-1).copy();
                    cornTime.minusOneMinute();
                } else {
                    // 자리 남으면 여유롭게
                    cornTime = bus.copy();
                }
            }
            
            bus.addMinutes(t);
        }        
        
        return cornTime.toString();
    }
}