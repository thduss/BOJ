import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();

        int time = 0;

        if (A < 0) {
            time += Math.abs(A) * C;
            time += D;
            time += B * E;
        } else {
            time += (B - A) * E;
        }

        System.out.println(time);
    }
}