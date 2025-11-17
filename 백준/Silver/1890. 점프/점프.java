import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		 
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				if (arr[i][j] == 0) continue;
				if (i==N-1 && j==N-1) continue;
				
				int v = arr[i][j];
				int nx = v+i;
				int ny = v+j;
				
				if (nx<N) dp[nx][j] += dp[i][j];
				if (ny<N) dp[i][ny] += dp[i][j];
			}
		}
				
		System.out.println(dp[N-1][N-1]);
	}
}
