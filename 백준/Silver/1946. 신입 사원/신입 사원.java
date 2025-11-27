import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][2];
            StringTokenizer st;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            // 서류 1등이 맨 앞
            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            int answer = 1;
            int min_score = arr[0][1]; // 면접 점수 '커트라인'

            for (int j = 1; j < N; j++) {
                if (arr[j][1] < min_score) {
                    answer++;
                    min_score = arr[j][1];
                }
            }

            System.out.println(answer);
        }
    }
}