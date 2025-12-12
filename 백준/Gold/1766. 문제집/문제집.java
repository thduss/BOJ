import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		int[] indegree = new int[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
 		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			indegree[b]++;
		}
		
		StringBuilder out = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			out.append(cur).append(" ");
			
			for(int i : adj[cur]) {
				indegree[i]--;
				if(indegree[i]==0) {
					queue.add(i);
				}
			}
		}
		
		System.out.println(out.toString());
	}
}