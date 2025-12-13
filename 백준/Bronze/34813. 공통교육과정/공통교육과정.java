import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        char category = s.charAt(0);
        
        if (category == 'F') {
            System.out.println("Foundation");
        } else if (category == 'C') {
            System.out.println("Claves");
        } else if (category == 'V') {
            System.out.println("Veritas");
        } else if (category == 'E') {
            System.out.println("Exploration");
        }
        
        sc.close();
    }
}