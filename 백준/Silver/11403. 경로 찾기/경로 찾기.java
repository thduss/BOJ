import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		int end;
		Node next;
		
		public Node(int end, Node next) {
			super();
			this.end = end;
			this.next = next;
		}
	}
	
	static Node[] adj;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		adj = new Node[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
                    adj[i] = new Node(j, adj[i]);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(find(i, j) + " ");
			}
			System.out.println();
		}
	}
	
	public static int find(int i, int j) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N];

        for (Node node = adj[i]; node != null; node = node.next) {
            que.add(node.end);
        }
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
            if (visited[cur]) continue;
            visited[cur] = true;
            
			if(cur==j) return 1;
			
			for(Node node=adj[cur]; node!=null; node=node.next) {
				if(!visited[node.end]) {
					que.add(node.end);
				}
			}
		}
		
		
		return 0;
	}
}