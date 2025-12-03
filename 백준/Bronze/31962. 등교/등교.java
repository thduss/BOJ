import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();

        int result = -1;

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int T = sc.nextInt();

            if (S + T <= X) {
                if (S > result) {
                    result = S;
                }
            }
        }

        System.out.println(result);
    }
}