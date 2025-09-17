import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		
		String n1="", n2="";
		for(int i=s1.length()-1; i>=0; i--) {
			n1 += s1.charAt(i);
			n2 += s2.charAt(i);
		}
		
		int s11 = Integer.parseInt(n1);
		int s22 = Integer.parseInt(n2);
		
		System.out.println(Math.max(s11, s22));
	}
}
