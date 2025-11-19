import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] answer = bfs(N, K);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static int[] bfs(int start, int end) {
        if (start >= end) {
            return new int[] { start - end, 1 };
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        // time[i] : i 지점에 도달하는 최소 시간
        int[] time = new int[100001];
        time[start] = 0;

        // count[i] : i지점에 도달하는 경로의 개수
        int[] count = new int[100001];
        count[start] = 1;

        int minTime = Integer.MAX_VALUE;
        int ways = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur == end) {
                if (minTime == Integer.MAX_VALUE) {
                    minTime = time[cur];
                    ways = count[cur];
                } else if (minTime == time[cur]) {
                    ways += count[cur];
                }
                continue;
            }

            int[] nArr = { cur - 1, cur + 1, cur * 2 };

            for (int next : nArr) {
                if (next >= 0 && next <= 100000) {
                    int nextTime = time[cur] + 1;

                    if (time[next] == 0) {
                        // 1. 처음 방문
                        time[next] = nextTime;
                        count[next] = count[cur];
                        que.add(next);
                    } else if (time[next] == nextTime) {
                        // 2. 같은 최단 시간 방문
                        count[next] += count[cur];
                    }
                }
            }
        }

        return new int[] { minTime, ways };
    }
}
