package dynamicProgramming.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S_3_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        //i번째 계단에 몇칸을 밟아서 올라올건가
        int[][] dp = new int[N + 1][3];

        dp[1][1] = stair[1];
        if (N >= 2) {
            dp[2][1] = stair[1] + stair[2];
            dp[2][2] = stair[2];
        }

        for (int i = 3; i <= N; i++) {
            //1칸을 오를 경우 반드시 직전에 두칸을 밟고 와야함 1칸 1칸 1칸은 연속된 3계단이라 불가능하니까
            //2칸을 오를경우 직전에 1칸이든 2칸이든 상관없으니까 Math.max
            dp[i][1] = dp[i - 1][2] + stair[i];
            dp[i][2] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stair[i];
        }

        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}
