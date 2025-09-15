import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Bus{
		int to, cost;
		Bus next;
		
		public Bus(int to, int cost, Bus next) {
			this.to = to;
			this.cost = cost;
			this.next = next;
		}
	}
	
	
	public static class Vertex implements Comparable<Vertex>{
		int no, totalCost;
		
		public Vertex(int no, int totalCost) {
			this.no = no;
			this.totalCost = totalCost;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.totalCost, o.totalCost);
		}
	}
	
	static Bus[] adjList;
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adjList = new Bus[N+1];
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Bus(to, cost, adjList[from]);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int ans = dijkstra(start, end);
		System.out.println(ans);
	}
	
	public static int dijkstra(int start, int end) {
		int[] costs = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(costs, INF);
		costs[start] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(start, 0));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();

			if(visited[cur.no]) continue;
			visited[cur.no]=true;
			
			for(Bus e = adjList[cur.no]; e != null; e=e.next) {
				if(visited[e.to]) continue;
				
				int nCost = cur.totalCost + e.cost;
				
				if(costs[e.to] > nCost) {
					costs[e.to] = nCost;
					pq.add(new Vertex(e.to, nCost));
				}
			}
		}
		
		return costs[end];
	}
}
