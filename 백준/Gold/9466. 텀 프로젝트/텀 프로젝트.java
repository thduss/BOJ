import java.util.*;
import java.io.*;

public class Main {
	public static int[] choice;
	public static boolean[] finished, visited;
	public static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder out = new StringBuilder();
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			choice = new int[N+1];
			finished = new boolean[N+1];
			visited = new boolean[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) choice[i] = Integer.parseInt(st.nextToken());
			
			count = 0;
			for(int i=1; i<=N; i++) {
				if(!finished[i]) {
					dfs(i);
				}
			}
			
			out.append(N-count).append("\n");
		}	
		
		System.out.println(out.toString());
	}
	
	public static void dfs(int current) {
		visited[current] = true;
		int next = choice[current];
		
		if(!visited[next]) {
			dfs(next);
		} else {
			if(!finished[next]) {
				count++;
				// cycle 인원 수 세기 (next 시작, current 꼬리)
				for(int i=next; i!=current; i=choice[i]) {
					count++;
				}
			}
		}
		finished[current] = true;
	}
	
}