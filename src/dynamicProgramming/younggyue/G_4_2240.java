package dynamicProgramming.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_4_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        //시간, 움직인 횟수, 자두의 위치
        int[][][] dp = new int[T + 1][W + 1][3];

        int[] tree = new int[T];

        for (int i = 0; i < T; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        if (tree[0] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int t = 2; t <= T; t++) {
            int curr = tree[t - 1];
            for (int w = 0; w <= W; w++) {
                //자두가 1번 나무에서 떨어지는 경우
                if (curr == 1) {
                    //자두가 1번에 있어서 1번 나무에서 떨어짐 안움직여도 받음
                    dp[t][w][1] = Math.max(dp[t][w][1], dp[t - 1][w][1] + 1);
                    //자두가 2번나무에 존재했다가 1번으로 이동하는 경우 자두 받음
                    // w > 0인 이유 : 한번도 이동안한 상태기 때문에 전에 이동한 경우가 존재할 수 없으니까
                    if (w > 0) {
                        dp[t][w][1] = Math.max(dp[t][w][1], dp[t - 1][w - 1][2] + 1);
                    }
                    //1번나무에서 2번 나무로 움직여서 자두 못받는 경우
                    if (w > 0) {
                        dp[t][w][2] = Math.max(dp[t][w][2], dp[t - 1][w - 1][1]);
                    }
                    //자두가 2번에 있어서 그냥 가만히 있어서 못 받는 경우
                    dp[t][w][2] = Math.max(dp[t][w][2], dp[t - 1][w][2]);
                    //자두가 2번나무에서 떨어지는 경우
                } else {
                    //자두가 2번에 존재해서 2번 나무에서 떨어져서 가만히 있어도 받는 경우
                    dp[t][w][2] = Math.max(dp[t][w][2], dp[t - 1][w][2] + 1);
                    //1번에서 2번나무로 이동해서 받는경우
                    if (w > 0) {
                        dp[t][w][2] = Math.max(dp[t][w][2], dp[t - 1][w - 1][1] + 1);
                    }
                    //2번에서 1번나무로 이동해서 못 받는 경우
                    if (w > 0) {
                        dp[t][w][1] = Math.max(dp[t][w][1], dp[t - 1][w - 1][2]);
                    }
                    //1번에 존재해서 가만히 있어도 못받는 경우
                    dp[t][w][1] = Math.max(dp[t][w][1], dp[t - 1][w][1]);
                }
            }
        }

        int result = 0;
        for (int w = 0; w <= W; w++) {
            result = Math.max(result, Math.max(dp[T][w][1], dp[T][w][2]));
        }
        System.out.println(result);
    }
}
