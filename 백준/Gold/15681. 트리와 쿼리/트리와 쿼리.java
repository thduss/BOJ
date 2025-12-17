import java.util.*;
import java.io.*;

public class Main {
	public static ArrayList<Integer>[] tree;
	public static int[] cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[N+1];
		cnt = new int[N+1];
		for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			tree[u].add(v);
			tree[v].add(u);
		}
		
		dfs(R, -1);
		
		StringBuilder out = new StringBuilder();
		for(int i=0; i<Q; i++) {
			int target = Integer.parseInt(br.readLine());
			
			out.append(cnt[target]).append("\n");
		}
		System.out.println(out.toString());
	}
	
	public static void dfs(int x, int parent) {
		cnt[x] = 1;
		
		for(int y : tree[x]) {
			if(y==parent) continue;
			dfs(y, x);
			cnt[x] += cnt[y];
		}
	}

}
