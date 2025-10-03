import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.y==o.y) return Integer.compare(this.x, o.x);
			return Integer.compare(this.y, o.y);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Node(x,y));
		}
		
		list.sort(null);
		
		for(Node n : list) {
			System.out.println(n.x + " " + n.y);
		}
	}
}