package simulation.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G_4_3190 {
    //어려웠던점 : 뱀의 몸상태를 관리하는걸 덱으로 한다는 발상 자체를 하지 못했음
    //게임 시작시간으로부터 몇초후를 증가하는 방향으로 주어지기때문에 중복도 없어서 map 써도 문제 없음
    // time 이 반복문을 돌면서 증가하고 map 에 time 을 키로 가질때 방향을 전환하는거니 이것도 깔끔
    public static int N;
    public static int K;
    public static int L;
    public static int[][] board;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static Map<Integer, Character> directionChanges = new HashMap<>();
    public static Deque<int[]> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x - 1][y - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directionChanges.put(time, dir);
        }

        System.out.println(simulate());

    }

    public static int simulate() {
        int x = 0;
        int y = 0;
        int dir = 0;
        int time = 0;
        snake.addLast(new int[]{x, y});
        board[x][y] = 2;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
                return time;
            }

            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
            } else {
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            if (directionChanges.containsKey(time)) {
                if (directionChanges.get(time) == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }

            x = nx;
            y = ny;
        }
    }
}
