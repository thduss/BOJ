import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new LinkedList[N+1];
		for(int i=1; i<=N; i++) graph[i] = new LinkedList<>();
		int[] indegree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int cnt = Integer.parseInt(st.nextToken());
			
			int before=0;
			for(int j=0; j<cnt; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if(j>0) {
					indegree[n]++;
					graph[before].add(n);
				}
				
				before=n;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) queue.add(i);
		}
		
		boolean[] visited = new boolean[N+1];
		StringBuilder out = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			out.append(cur).append("\n");
			
			if(visited[cur]) {
				System.out.println(0);
				return;
			}
			visited[cur] = true;
			
			for(int n : graph[cur]) {
				indegree[n]--;
				if(indegree[n]==0) {
					queue.add(n);
				}
			}
			
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(out.toString());
	}
}