import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		makeSet(N);
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}
		
		int answer=0;
		int root1 = findSet(1);
		for(int i=1; i<=N; i++) {
			if(findSet(i)==root1) answer++;
		}
		System.out.println(answer-1);
	}
	
	public static void makeSet(int n) {
		parent = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x==parent[x]) return x;
		
		return parent[x] = findSet(parent[x]);
	}
	
	public static void union(int a, int b) {
		if(findSet(a)==findSet(b)) return;
		
		parent[findSet(b)] = findSet(a);
	}
}