import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // A 구하기
        int a = arrayA[0];
        for(int i=1; i<arrayA.length; i++){
            int b = arrayA[i];
            
            a = gcd(a,b);
        }
        if(check(a, arrayB)){
            answer = a;   
        }
        
        // B 구하기
        int b = arrayB[0];
        for(int i=1; i<arrayB.length; i++){
            b = gcd(arrayB[i],b);
        }
        
        if(check(b, arrayA)){
            answer = Math.max(answer, b);   
        }
        
        return answer;
    }

    // 최대공약수 
    public static int gcd(int a, int b){
        if(a%b==0) return b;
        
        return gcd(b, a%b);
    }
    
    public static boolean check(int n, int[] arr){
        for(int c : arr){
            if(c%n==0) return false;
        }
        return true;
    }
}