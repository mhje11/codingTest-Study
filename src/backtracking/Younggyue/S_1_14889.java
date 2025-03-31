package backtracking.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_1_14889 {
    public static int N;
    public static boolean[] visited;
    public static int[][] arr;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 0);
        System.out.println(min);

    }

    public static void backtracking(int start, int depth) {
        // N / 2 만큼 채우면 인원을 다 고른거니까 기저 조건은 N / 2
        if (depth == N / 2) {
            calculate();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculate() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j] + arr[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(start - link));
    }

}
