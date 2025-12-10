import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int[] pick; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) houses.add(new int[]{i, j});
                else if (v == 2) chickens.add(new int[]{i, j});
			}
		}
		
		pick = new int[M];
		dfs(0,0);
		System.out.println(answer);
	}
	
	public static void dfs(int depth, int start) {
		if(depth == M) {
			int sum = 0;
			for(int[] h : houses) {
				int hx = h[0], hy = h[1];
				int minDist = Integer.MAX_VALUE;
				
				for(int k=0; k<M; k++) {
					int[] c = chickens.get(pick[k]);
					int dist = Math.abs(hx-c[0]) + Math.abs(hy-c[1]);
					if(dist < minDist) minDist = dist;
				}
				sum += minDist;
				if(sum >= answer) return;
			}
			
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=start; i<chickens.size(); i++) {
			pick[depth] = i;
			dfs(depth+1, i+1);
		}
	}
}