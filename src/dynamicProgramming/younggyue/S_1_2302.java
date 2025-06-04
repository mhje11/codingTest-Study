package dynamicProgramming.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class S_1_2302 {
    //dp의 인덱스 == 몇명인지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] vip = new int[M];

        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 1;
        int prev = 0;

        for (int i = 0; i < M; i++) {
            int curr = vip[i];
            int length = curr - prev - 1;
            result *= dp[length];
            prev = curr;
        }

        result *= dp[N - prev];

        System.out.println(result);
    }
}
