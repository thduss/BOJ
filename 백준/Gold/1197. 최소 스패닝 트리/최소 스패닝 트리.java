import java.io.*;
import java.util.*;

public class Main {
	static List<Vertex>[] graph;
	
	public static class Vertex implements Comparable<Vertex> {
		int to, cost;
		
		Vertex(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new LinkedList[V+1];
		for(int i=1; i<=V; i++) graph[i] = new LinkedList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Vertex(b,c));
			graph[b].add(new Vertex(a,c));
		}
		
		boolean visited[] = new boolean[V+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(1,0));
		
	     int totalCost = 0;
        int connected = 0;
        
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			
			totalCost += cur.cost;
			connected++;
			
			for(Vertex next : graph[cur.to]) {
				if(!visited[next.to]) pq.offer(next);
			}
		}
		
		if(connected==V) System.out.println(totalCost);
		
	}

}
