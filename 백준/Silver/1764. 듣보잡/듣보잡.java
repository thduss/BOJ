import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			set.add(name);
		}
		
		List<String> list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			
			if(set.contains(name)) {
				list.add(name);
			}
		}
		
		String[] answer = list.toArray(new String[list.size()]);
		Arrays.sort(answer);
		
		System.out.println(answer.length);
		for(String ans : answer) {
			System.out.println(ans);
		}
	}
}