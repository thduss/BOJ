import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    static int N;
    static int[][] dp;
    static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][2];

        // 인접리스트 만들기
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) {
            adjList[i] = new ArrayList<>();
        }

        String[] strArr;
        for (int i = 0; i < N - 1; i++) {
            strArr = br.readLine().split(" ");
            int num1 = Integer.parseInt(strArr[0]);
            int num2 = Integer.parseInt(strArr[1]);
            adjList[num1].add(num2);
            adjList[num2].add(num1);
        }

        // 1부터 시작하여 최소 얼리어답터를 구하는 dfs구현
        getMinAdapter(1, 0);
        int answer = Math.min(dp[1][0], dp[1][1]);
        System.out.println(answer);
    }


    // 본인이 얼리어답터 -> dp[자신][1] -> 주변친구가 얼리어답터인 것과 아닌 것 중 최솟값
    // 본인이 얼리어답터가 아니면 -> dp[자신][0] -> 주변 모든 친구가 얼리어답터
    private static void getMinAdapter(int now, int parent) {
        dp[now][0] = 0;
        dp[now][1] = 1;

        for (Integer next : adjList[now]) {
            if(parent == next){
                continue;
            }
            getMinAdapter(next, now); // dfs
            dp[now][0] += dp[next][1]; // 자식은 무주건 얼리어답터
            dp[now][1] += Math.min(dp[next][0], dp[next][1]); // 주변친구가 얼리어답터이거나 아니거나 최솟값
        }
    }
}