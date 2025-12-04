import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int[] indegree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			indegree[b]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}
		
		StringBuilder out = new StringBuilder();
		
		while(!que.isEmpty()) {
			int node = que.poll();
			out.append(node).append(" ");
			
			for(int i : adjList[node]) {
				indegree[i]--;
				if(indegree[i]==0) {
					que.add(i);
				}
			}
		}
		
		
		System.out.println(out.toString());
	}

}