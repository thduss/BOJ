import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long R = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        
        // (R + N - 1) / N 은 올림 효과를 냅니다
        long rows = (R + N - 1) / N;
        long cols = (C + N - 1) / N;
        
        System.out.println(rows * cols);
    }
}