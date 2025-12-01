import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) B[i] = Integer.parseInt(st.nextToken());
		
		
		Map<Long, Long> mapA = new HashMap<>();
		Map<Long, Long> mapB = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			long sum=0;
			for(int j=i; j<N; j++) {
				sum += A[j];
				long count = mapA.getOrDefault(sum, 0L);
				mapA.put(sum, count+1);
			}
		}
		
		for(int i=0; i<M; i++) {
			long sum=0;
			for(int j=i; j<M; j++) {
				sum += B[j];
				long count = mapB.getOrDefault(sum, 0L);
				mapB.put(sum, count+1);
			}
		}
		
		long answer=0;
		for(Map.Entry<Long, Long> entryA : mapA.entrySet()) {
			Long aSum = entryA.getKey();
			Long aCount = entryA.getValue();
			
			long diff = T - aSum;
			Long bCount = mapB.getOrDefault(diff, 0L);
			answer+=(aCount*bCount);
		}
		
		System.out.println(answer);
	}
}   
