import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(A[1]);
		
		for(int i=2; i<=N; i++) {
			int key = A[i];
			
			if(list.get(list.size()-1)<key) {
				list.add(key);
			} else {
				int low = 0;
				int high = list.size()-1;
				
				while(low<high) {
					int mid = (low+high)/2;
					
					if(list.get(mid)>=key) high = mid;
					else low = mid+1;
				}
				list.set(high, key);
			}
		}
		System.out.println(list.size());
	}
}