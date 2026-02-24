import java.io.*;

public class Main {
    public static boolean[] colCheck, diag1Check, diag2Check;
    public static int N, count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        colCheck = new boolean[N];
        diag1Check = new boolean[2 * N];
        diag2Check = new boolean[2 * N];

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int row){
        if(row == N){
            count++;
            return;
        }

        for(int col =0; col<N; col++){
            if(isSafe(row, col)){
                setQueens(row, col, true);
                dfs(row+1);
                setQueens(row, col, false);
            }
        }
    }

    private static boolean isSafe(int r, int c){
        return !colCheck[c] && !diag1Check[r+c] && !diag2Check[r-c+N];
    }

    private static void setQueens(int r, int c, boolean state){
        colCheck[c] = state;
        diag1Check[r+c] = state;
        diag2Check[r-c+N] = state;
    }
}
