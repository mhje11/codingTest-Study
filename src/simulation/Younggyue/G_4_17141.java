package simulation.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//어려웠던점 : 구현 자체는 백트래킹과 bfs 를 사용하면 되는걸 바로 생각했지만
//사소한 부분에서 실수가 많았다. map 배열로 검사해야하는데 원본이었던 arr 배열로 검사하는 부분도 잘못됐고
//복사한 배열에서는 바이러스를 놓을수있는 위치인 2를 굳이 둘필요없이 0으로 바꾸는게 낫기 때문에 이 부분도 잘못됐었음
public class G_4_17141 {
    public static int M;
    public static int N;
    public static int[][] arr;
    public static boolean[] selected;
    public static int min = Integer.MAX_VALUE;
    public static List<int[]> virus = new ArrayList<>();
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[virus.size()];

        backtracking(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void backtracking(int depth, int start) {
        if (depth == M) {
            List<int[]> activeVirus = new ArrayList<>();
            for (int i = 0; i < virus.size(); i++) {
                if (selected[i]) {
                    activeVirus.add(virus.get(i));
                }
            }
            int time = bfs(activeVirus);
            if (time != Integer.MAX_VALUE) {
                min = Math.min(min, time);
            }
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                backtracking(depth + 1, i + 1);
                selected[i] = false;
            }
        }


    }

    public static int bfs(List<int[]> activeVirus) {
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 2) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = arr[i][j];
                }
            }
        }

        for (int[] v : activeVirus) {
            queue.offer(new int[]{v[0], v[1], 0});
            visited[v[0]][v[1]] = true;
        }
        int maxTime = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            maxTime = Math.max(maxTime, current[2]);

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, current[2] + 1});
                    }

                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return maxTime;
    }
}
