package dynamicProgramming.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S_1_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];
        int[] prev = new int[X + 1];

        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        System.out.println(dp[X]);

        while (X > 0) {
            System.out.print(X + " ");
            X = prev[X];
        }
    }
}
