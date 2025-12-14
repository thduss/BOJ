import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] skills = new int[4];
        
        for (int i = 0; i < 4; i++) {
            skills[i] = sc.nextInt();
        }
        
        Arrays.sort(skills);
        
        int team1 = skills[0] + skills[3];
        int team2 = skills[1] + skills[2];
        
        System.out.println(Math.abs(team1 - team2));
        
        sc.close();
    }
}