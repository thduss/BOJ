import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer, row, col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		partition(0,0, (int)Math.pow(2, N));
	}
	
	public static void partition(int r, int c, int size) {
		if(size==1) {
			System.out.println(answer);
			return;
		}
		
		int nSize = size/2;
		int block = nSize*nSize;
		 
		if(row<(r+nSize) && col<(c+nSize)) {
			partition(r,c,nSize); // 2사분면
		} 
		else if (row<(r+nSize) && col>=(c+nSize)) {
			answer += block;
			partition(r, c+nSize, nSize); // 1사분면
		}
		else if  (row>=(r+nSize) && col<(c+nSize)) {
			answer += 2*block;
			partition(r+nSize, c, nSize); // 3사분면
		}
		else if  (row>=(r+nSize) && col>=(c+nSize)) {
			answer += 3*block;
			partition(r+nSize, c+nSize, nSize); // 4사분면
		}	
	}
}