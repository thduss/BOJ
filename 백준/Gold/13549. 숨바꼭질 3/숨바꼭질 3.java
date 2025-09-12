import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		int x, time;
		
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}
	
	static int N, K;
    static final int MAX = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(N,K));
		
	}
	
	public static int dijkstra(int start, int end) {
		if (start >= end) return start - end;

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));
		
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x, t = cur.time;

            if (x == end) return t;          
            if (t > dist[x]) continue;

            // 0초: x -> 2x
            int nx = x * 2;
            if (nx <= MAX && dist[nx] > t) {
                dist[nx] = t;
                pq.add(new Node(nx, t));
            }

            // 1초: x -> x-1
            nx = x - 1;
            if (nx >= 0 && dist[nx] > t + 1) {
                dist[nx] = t + 1;
                pq.add(new Node(nx, t + 1));
            }

            // 1초: x -> x+1
            nx = x + 1;
            if (nx <= MAX && dist[nx] > t + 1) {
                dist[nx] = t + 1;
                pq.add(new Node(nx, t + 1));
            }
        }
        return dist[end];
	}
}