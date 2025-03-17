package bfs_dfs.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_4_5427 {
    //어려웠던점 : 상근이와 불의 확산을 동시에 처리해야 했던 부분
    //상근이와 불의 확산을 두가지의 큐로 나누어 bfs를 2개 돌림

    public static int T;
    public static int w;
    public static int h;
    public static char[][] arr;
    public static boolean[][] isVisit;
    public static Queue<int[]> fireQueue;
    public static Queue<int[]> sangQueue;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            isVisit = new boolean[h][w];

            fireQueue = new LinkedList<>();
            sangQueue = new LinkedList<>();

            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                for (int k = 0; k < w; k++) {
                    arr[j][k] = s.charAt(k);
                    //불의 시작점 큐에 추가
                    if (arr[j][k] == '*') {
                        fireQueue.offer(new int[]{j, k});
                        //상근이 시작점 추가
                    } else if (arr[j][k] == '@') {
                        sangQueue.offer(new int[]{j, k});
                        isVisit[j][k] = true;
                    }
                }
            }
            int result = bfs();
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    public static int bfs() {
        int time = 0;

        //상근이가 더이상 이동할 수 없을 때 까지
        while (!sangQueue.isEmpty()) {
            //불의 확산을 먼저
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                int[] fire = fireQueue.poll();
                int x = fire[0];
                int y = fire[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] == '.') {
                        arr[nx][ny] = '*';
                        fireQueue.offer(new int[]{nx, ny});
                    }
                }
            }

            //상근이의 이동
            int sangSize = sangQueue.size();
            for (int i = 0; i < sangSize; i++) {
                int[] sang = sangQueue.poll();
                int x = sang[0];
                int y = sang[1];

                //벽 끝에 닿으면 탈출
                if (x == 0 || x == h - 1 || y == 0 || y == w - 1) {
                    return time + 1;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && !isVisit[nx][ny] && arr[nx][ny] == '.') {
                        isVisit[nx][ny] = true;
                        sangQueue.offer(new int[]{nx, ny});
                    }
                }
            }
            time++;
        }

        return -1;
    }
}
