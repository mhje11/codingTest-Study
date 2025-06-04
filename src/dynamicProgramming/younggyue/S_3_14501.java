package dynamicProgramming.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_3_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i][0] = t;
            arr[i][1] = p;
        }

        int[] dp = new int[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            int time = arr[i][0];
            int pay = arr[i][1];

            if (i + time <= N) {
                dp[i] = Math.max(pay + dp[i + time], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[0]);
    }
}
