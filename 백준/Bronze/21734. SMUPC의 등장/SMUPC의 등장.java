import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		
		for(int i=0; i<st.length(); i++) {
			char c = st.charAt(i);
			
			int asci = (byte)c;
			
			String num = Integer.toString(asci);
			int cnt=0;
			for(int j=0; j<num.length(); j++) {
				cnt += num.charAt(j)-'0';
			}
			
			for(int j=0; j<cnt; j++) System.out.print(c);
			System.out.println();
		}
	}
}
