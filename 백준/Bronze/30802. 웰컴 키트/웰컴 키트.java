import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = sc.nextInt();
        }

        int T = sc.nextInt();
        int P = sc.nextInt();

        int tCount = 0;
        for (int i = 0; i < 6; i++) {
            tCount += (sizes[i] + T - 1) / T;
        }

        System.out.println(tCount);
        System.out.println((N / P) + " " + (N % P));
    }
}