package backtracking.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_2_15666_V2 {
    //어려웠던점 : 같은 depth 에서 중복을 제거하는 prev 을 떠올리지 못했음
    public static int N;
    public static int M;
    public static int[] arr;
    public static int[] result;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        result = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtracking(0, 0);
        System.out.println(sb);

    }

    public static void backtracking(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (arr[i] == prev) {
                continue;
            }
            result[depth] = arr[i];
            prev = arr[i];
            backtracking(i, depth + 1);
        }
    }
}
