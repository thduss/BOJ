import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K, answer;
	static int[] best;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		answer = Integer.MAX_VALUE;
        best = new int[100001];
        Arrays.fill(best, Integer.MAX_VALUE);
        
		dfs(0,N);
		System.out.println(answer);
	}
	
	public static void dfs(int time, int pos) {
		if(time>=answer) return;
		if(pos<0 || pos>100000) return;
		if (time >= best[pos]) return;
		best[pos] = time;
		
		if(pos >= K) {
			if(pos>K) time+=(pos-K);
			
			answer = Math.min(answer, time);
			return;
		}
		
		dfs(time+1, pos*2);
		dfs(time+1, pos+1);
		dfs(time+1, pos-1);

	}
}
