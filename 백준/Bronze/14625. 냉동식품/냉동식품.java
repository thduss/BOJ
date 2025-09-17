import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int startH = Integer.parseInt(st.nextToken());
		int startM = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int endH = Integer.parseInt(st.nextToken());
		int endM = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		 int curH = startH, curM = startM;
	        int count = 0;

	        while (true) {
	            if (hasDigit(curH, N) || hasDigit(curM, N)) count++;

	            if (curH == endH && curM == endM) break;

	            curM++;
	            if (curM == 60) {
	                curM = 0;
	                curH++;
	                if (curH == 24) curH = 0;
	            }
	        }

	        System.out.println(count);
	    }

	    private static boolean hasDigit(int x, int n) {
	        return (x / 10 == n) || (x % 10 == n);
	    }
}