import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static class Node implements Comparable<Node>{
		int absX, x;
		
		public Node(int absX, int x) {
			this.absX = absX;
			this.x = x;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.absX == o.absX) {
				return Integer.compare(this.x, o.x);
			} else {
				return Integer.compare(this.absX, o.absX);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			Node curX = new Node(Math.abs(x), x);
			
			if(x==0) {
				if(minHeap.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(minHeap.poll().x);
				}
			} else {
				minHeap.add(curX);
			}
		}
	}
}