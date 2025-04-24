package simulation.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_4_14500 {
    //어려웠던점 : 애초에 브루트포스말고 풀수있는 방법을 생각하지 못했었음 근데 말도안되는 노가다이기에 다른 방법이 있을거라 생각했지만 해결 방법을 못찾았었음
    //일반적인 bfs로는 ㅗ 모양을 해결할 수 없었는데 depth = 2 일경우 좌우로 뻗는 가지를 하나 더 만들어주면 끝이라는 부분
    //그 외에 나머지 모양은 bfs로 모두 해결되는 모양
    public static int N;
    public static int M;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                backtracking(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);

    }

    public static void backtracking(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                continue;
            }

            if (depth == 2) {
                visited[nx][ny] = true;
                backtracking(x, y, sum + arr[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            backtracking(nx, ny, sum + arr[nx][ny], depth + 1);
            visited[nx][ny] = false;
        }
    }


}
