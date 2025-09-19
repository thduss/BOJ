import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		String cnt="";
		Stack<String> st = new Stack<>();
		for(int i=0; i<line.length(); i++) {
			char c = line.charAt(i);
			
			if(c=='-') {
				if(!cnt.isEmpty()) st.push(cnt);
				cnt = "";
				st.push("-");
				
			} else if(c=='+') {
				if(!cnt.isEmpty()) st.push(cnt);
				cnt = "";
				st.add("+");
			} else {
				cnt+=c;
			}
		}
		
		if(!cnt.isEmpty()) st.push(cnt);
		
		Stack<String> st2 = new Stack<>();
		while(!st.isEmpty()) {
			st2.add(st.pop());
		}
		
		int result = 0;
		boolean minusMode = false;
		while(!st2.isEmpty()) {
			String cur = st2.pop();
			if(cur.equals("-")) {
				minusMode = true;
			} else if(cur.equals("+")) {
				continue;
			} else {
				int num = Integer.parseInt(cur);
				if(minusMode) result -= num;
				else result += num;
			}
		}
		System.out.println(result);
	}
}