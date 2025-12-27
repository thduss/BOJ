import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N 입력 받기 (0 <= N <= 20)
        int N = sc.nextInt();
        
        // 결과 출력
        System.out.println(factorial(N));
        
        sc.close();
    }

    // 팩토리얼을 구하는 재귀 함수
    // 반환 타입을 반드시 long으로 해야 함
    public static long factorial(int n) {
        // 0!과 1!은 1이다. (종료 조건)
        if (n <= 1) {
            return 1;
        }
        // 재귀 호출: n * (n-1)!
        return n * factorial(n - 1);
    }
}