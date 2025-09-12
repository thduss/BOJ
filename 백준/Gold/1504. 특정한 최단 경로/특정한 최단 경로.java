import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// 간선 정보
	public static class Node{
		int to;
		int w;
		Node next;
		
		public Node(int to, int w, Node next) {
			this.to = to;
			this.w = w;
			this.next = next;
		}
	}
	
	// 다익스트라 탐색 과정에서 정점 상태  정보
	static class Vertex implements Comparable<Vertex>{
		int no, totalDistance;
		
		public Vertex(int no, int totalDistance) {
			this.no = no;
			this.totalDistance = totalDistance;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.totalDistance, o.totalDistance);
		}
	}
	
	static int N, E;
	static final int INF = Integer.MAX_VALUE;
	static Node[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new Node[N+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a] = new Node(b,c,adj[a]);
			adj[b] = new Node(a,c,adj[b]);
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken()); 
	
		int[] d1 = dijkstra(1);
		int[] dv1 = dijkstra(v1);
		int[] dv2 = dijkstra(v2);
		
		long route1 = safeAdd(d1[v1],dv1[v2],dv2[N]); 
		long route2 = safeAdd(d1[v2],dv2[v1],dv1[N]);
		
		long ans = Math.min(route1, route2);
		
		System.out.println(ans>=INF ? -1 : ans);
	}
	
	public static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Vertex(start, 0));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			if(visited[cur.no]) continue;
			visited[cur.no] = true;
			
			for(Node e = adj[cur.no]; e != null; e = e.next) {
				if(visited[e.to]) continue;
				int nd = cur.totalDistance + e.w;
				if(nd<dist[e.to]) {
					dist[e.to] = nd;
					pq.offer(new Vertex(e.to, nd));
				}
				
			}
		}
		return dist;	
	}
	
    static long safeAdd(long a, long b, long c) {
        if (a >= INF || b >= INF || c >= INF) return INF;
        long s = a + b; if (s >= INF) return INF;
        s += c; return s >= INF ? INF : s;
    }
}