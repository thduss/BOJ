import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int[][] dp = new int[str1.length+1][str2.length+1];
		
		for(int i=1; i<=str1.length; i++) {
			for(int j=1; j<=str2.length; j++) {
				if(str1[i-1] == str2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		StringBuilder out = new StringBuilder();
		out.append(dp[str1.length][str2.length]).append("\n");
		
		Deque<Character> stack = new ArrayDeque<>();
		int n = str1.length, m = str2.length;
		while(!(n==0 || m==0)) {
			if(dp[n][m]==dp[n-1][m]) {
				n--;
			} else if (dp[n][m]==dp[n][m-1]) {
				m--;
			} else {
				stack.push(str1[n-1]);
				n--;
				m--;
			}
		}
		
		while(!stack.isEmpty()) {
			out.append(stack.poll());
		}
		
		System.out.println(out.toString());
	}
}
