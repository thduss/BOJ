import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        long totalNeeded = n * 3;

        if (totalNeeded > m) {
            System.out.println((totalNeeded - m) * p + q);
        } else {
            System.out.println(0);
        }
    }
}