import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] cup = new boolean[N+1];
		cup[X] = true;

		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(cup[a]) {
				cup[a] = false;
				cup[b] = true;
			} else if(cup[b]) {
				cup[b] = false;
				cup[a] = true;
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(cup[i]) {
				System.out.println(i);
				break;
			}
		}
	}
}
