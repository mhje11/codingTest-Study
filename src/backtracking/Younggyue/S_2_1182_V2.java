package backtracking.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2_1182_V2 {
    public static int N, S;
    public static int[] arr;
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);

        //공집합인 경우는 제외
        if (S == 0) {
            count--;
        }
        System.out.println(count);

    }

    public static void backtracking(int depth, int sum) {

        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        // 해당 원소를 포함하는경우
        backtracking(depth + 1, sum + arr[depth]);

        // 해당 원소를 포함하지 않는 경우
        backtracking(depth + 1, sum);
    }
}
