import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> Genre = new HashMap<>();
        Map<String, PriorityQueue<int[]>> Song = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            Genre.put(genre, Genre.getOrDefault(genre, 0)+play);
            
            if(!Song.containsKey(genre)){
                Song.put(genre, new PriorityQueue<>((a,b)-> b[1]- a[1]));
            }
            Song.get(genre).add(new int[]{i, play});
        }
        
        List<String> sortedGenre = new ArrayList<>(Genre.keySet());
        sortedGenre.sort((g1, g2) -> Genre.get(g2) - Genre.get(g1));
        
        List<Integer> answerList = new ArrayList<>();
        for(String genre : sortedGenre){
            PriorityQueue<int[]> maxHeap = Song.get(genre);
            answerList.add(maxHeap.poll()[0]);
            
            if(!maxHeap.isEmpty()){
                answerList.add(maxHeap.poll()[0]);
            }
        }
        
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}