import java.util.*;
import java.io.*;

public class Main {
	public static class gemstone implements Comparable<gemstone> {
		private int m, v;
		
		public gemstone(int m, int v) {
			this.m = m;
			this.v = v;
		}
		
		@Override
		public int compareTo(gemstone o) {
			return Integer.compare(this.m, o.m);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<gemstone> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.add(new gemstone(m,v));
		}
		Collections.sort(list);
		
		Long [] C = new Long[K];
		for(int i=0; i<K; i++) {
			C[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(C);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		long sum=0;
		int listIdx=0;
		
		for(int i=0; i<K; i++) {
			while(listIdx<N && list.get(listIdx).m <= C[i]) {
				pq.offer(list.get(listIdx).v);
				listIdx++;
			}
			
			if(!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		
		System.out.println(sum);
		
	}
}
