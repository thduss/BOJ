import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // e: 가지고 있는 빈 병 수
        // f: 그날 발견한 빈 병 수
        // c: 새 병으로 바꾸는데 필요한 빈 병 수
        int e = sc.nextInt();
        int f = sc.nextInt();
        int c = sc.nextInt();

        // 1. 초기 전체 빈 병의 개수 합산
        int totalEmpty = e + f;
        int totalDrank = 0;

        // 2. 빈 병이 교환 가능한 개수(c)보다 많거나 같을 때까지 반복
        while (totalEmpty >= c) {
            // 교환 받은 새 병의 개수
            int newBottles = totalEmpty / c;
            
            // 교환하고 남은 빈 병의 개수
            int remainingMap = totalEmpty % c;

            // 마신 병 수 누적
            totalDrank += newBottles;

            // 현재 빈 병 개수 갱신 
            // (방금 마셔서 생긴 빈 병 + 아까 교환 못 하고 남은 빈 병)
            totalEmpty = newBottles + remainingMap;
        }

        System.out.println(totalDrank);
        
        sc.close();
    }
}