import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();

        int[] counts = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int vote = sc.nextInt();
            if (vote != 0) {
                counts[vote]++;
            }
        }

        int maxVotes = 0;
        for (int i = 1; i <= N; i++) {
            if (counts[i] > maxVotes) {
                maxVotes = counts[i];
            }
        }
        
        if (maxVotes == 0) {
            System.out.println("skipped");
        } else {
            int tieCount = 0;
            int winnerIndex = 0;

            for (int i = 1; i <= N; i++) {
                if (counts[i] == maxVotes) {
                    tieCount++;
                    winnerIndex = i;
                }
            }

            if (tieCount > 1) {
                System.out.println("skipped");
            } else {
                System.out.println(winnerIndex);
            }
        }
        
        sc.close();
    }
}