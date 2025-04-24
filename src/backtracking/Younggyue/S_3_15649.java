package backtracking.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_3_15649 {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int[] result;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        backtracking(0);
        System.out.println(sb);

    }

    public static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
