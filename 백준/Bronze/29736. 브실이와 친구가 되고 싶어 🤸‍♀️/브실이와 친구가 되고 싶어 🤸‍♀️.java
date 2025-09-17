import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int left = Math.max(A, K - X);
        int right = Math.min(B, K + X);

        int answer = 0;
        if (left <= right) {
            answer = right - left + 1; // 교집합 길이
        }

        if (answer == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }
}