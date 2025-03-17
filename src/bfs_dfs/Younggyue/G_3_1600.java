package bfs_dfs.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_3_1600 {
    //어려웠던점 : K번의 횟수를 어떻게 사용할것인가 무조건 먼저써야한다 생각했었음 하지만 dp문제의 경우를 따지는것 처럼
    //visited 배열을 3차원으로 생성해서 해당 지점을 몇번쨰 k의 사용으로 왔는지 확인하면 됨
    public static int K;
    public static int W;
    public static int H;
    public static int[][] arr;
    public static boolean[][][] visited;
    public static int[] horseX = new int[]{-2, -2, 2, 2, -1, -1, 1, 1};
    public static int[] horseY = new int[]{-1, 1, -1, 1, -2, 2, -2, 2};
    public static int[] dx = new int[] {-1, 1, 0, 0};
    public static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            int kUsed = current[3];

            if (x == H - 1 && y == W - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][kUsed] && arr[nx][ny] == 0) {
                    visited[nx][ny][kUsed] = true;
                    queue.offer(new int[]{nx, ny, count + 1, kUsed});
                }
            }

            if (kUsed < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + horseX[i];
                    int ny = y + horseY[i];

                    //도착지점은 장애물이면 안되니까 arr[nx][ny] == 0
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][kUsed + 1] && arr[nx][ny] == 0) {
                        visited[nx][ny][kUsed + 1] = true;
                        queue.offer(new int[]{nx, ny, count + 1, kUsed + 1});
                    }
                }
            }
        }
        return -1;
    }
}
