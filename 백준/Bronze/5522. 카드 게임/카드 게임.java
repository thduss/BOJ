import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        
        int total = 0; // 총점을 저장할 변수
        
        // 5번 반복하며 숫자를 입력받아 total에 더함
        for (int i = 0; i < 5; i++) {
            total += sc.nextInt();
        }
        
        // 결과 출력
        System.out.println(total);
        
        // Scanner 닫기 (필수는 아니지만 권장)
        sc.close();
    }
}