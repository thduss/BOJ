import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		dfs(0,1);
		
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int next) {
		if(depth==m) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int j=next; j<=n; j++) {
			arr[depth] = j;
			dfs(depth+1, j);
		}
	}
}