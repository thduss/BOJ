import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] card = new int[N];
		int[] score = new int[1000001];
		boolean[] exists = new boolean[1000001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			exists[card[i]] = true;
		}
		
		for(int i : card) {
			// i의 배수를 탐색
			for(int target = i*2; target<=1000000; target+=i) {
				if(exists[target]) {
					score[i]++;
					score[target]--;
				}
			}
		}
		
		
		StringBuilder out = new StringBuilder();
		for(int i=0; i<N; i++) out.append(score[card[i]]).append(" ");
		System.out.println(out.toString());
	}
}
