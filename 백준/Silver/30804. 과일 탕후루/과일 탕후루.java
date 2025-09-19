import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] fruits = new int[N];
		for(int i=0; i<N; i++) fruits[i] = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> cnt = new HashMap<>();
		int maxLen=0, left=0;
		for(int right=0; right<N; right++) {
			cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0)+1);
			
			while(cnt.size()>2) {
				int f = fruits[left++];
				int c = cnt.get(f) - 1;
				if(c==0) cnt.remove(f);
				else cnt.put(f, c);
			}
			
			maxLen = Math.max(maxLen, right-left+1);
		}
		
		System.out.println(maxLen);
	}
}