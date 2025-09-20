import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] X = new int[N];
		int[] sortX = new int[N];
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
			sortX[i] = X[i];
		}
		
		Arrays.sort(sortX);
		int rank=0;
		for(int v : sortX) {
			if(!rankingMap.containsKey(v)){
				rankingMap.put(v, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : X) {
			int ranking = rankingMap.get(key);
			sb.append(ranking).append(' ');
		}
		System.out.println(sb);
	}
}
