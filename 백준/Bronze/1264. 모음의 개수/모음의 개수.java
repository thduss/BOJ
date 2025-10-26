import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine().trim().toLowerCase();
			if(str.equals("#")) break;
			
			int answer=0;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c=='a' || c=='e' || c=='i' || c=='o'|| c=='u') answer++;
			}
			System.out.println(answer);
			
		}
		
	}
}