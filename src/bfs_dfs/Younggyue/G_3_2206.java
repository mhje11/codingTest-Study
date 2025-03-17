package bfs_dfs.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_3_2206 {
    //어려웠던점 : 문제를 잘못이해해서 전체 이동에서 단 한번 부술 수 있는 벽을 이동마다 한번 부수는게 가능하다 생각함
    //문제 자체는 G_3_2206과 유사해서 크게 어려움은 없었음
    public static int N;
    public static int M;
    public static int[][] arr;
    public static boolean[][][] visited;
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            int distance = current[3];
            if (N - 1 == x && M - 1 == y) {
                return distance;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0 && !visited[nx][ny][count]) {
                        visited[nx][ny][count] = true;
                        queue.offer(new int[]{nx, ny, count, distance + 1});
                    }

                    if (arr[nx][ny] == 1 && count == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new int[]{nx, ny, 1, distance + 1});
                    }
                }

            }
        }
        return -1;
    }
}
