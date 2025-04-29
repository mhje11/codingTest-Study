package simulation.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_4_14499 {
    //어려웠던점 일반적으로 동쪽으로 굴리는것과 달리 바닥면을 기준으로 회전시킨다는 점을 생각하지 못했음
    public static int N;
    public static int M;
    public static int currentX;
    public static int currentY;
    public static int K;
    public static int[][] arr;
    public static int[] dice;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        currentX = Integer.parseInt(st.nextToken());
        currentY = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dice = new int[6];
        Arrays.fill(dice, 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken());
            roll(command);
        }


    }

    public static void roll(int command) {
        int nx = currentX + dx[command - 1];
        int ny = currentY + dy[command - 1];
        if (nx < N && ny < M && nx >= 0 && ny >= 0) {
            currentX = nx;
            currentY = ny;
            rotateDice(command);
            if (arr[nx][ny] == 0) {
                arr[nx][ny] = dice[5];
            } else {
                dice[5] = arr[nx][ny];
                arr[nx][ny] = 0;
            }
            System.out.println(dice[0]);
        }

    }

    public static void rotateDice(int dir) {
        int[] temp = dice.clone();
        switch (dir) {
            case 1: // 동쪽
                dice[0] = temp[3]; // 위  ← 왼
                dice[2] = temp[0]; // 동  ← 위
                dice[5] = temp[2]; // 바닥 ← 동
                dice[3] = temp[5]; // 왼  ← 바닥
                break;
            case 2: // 서쪽
                dice[0] = temp[2];
                dice[3] = temp[0];
                dice[5] = temp[3];
                dice[2] = temp[5];
                break;
            case 3: // 북쪽
                dice[0] = temp[4];
                dice[1] = temp[0];
                dice[5] = temp[1];
                dice[4] = temp[5];
                break;
            case 4: // 남쪽
                dice[0] = temp[1];
                dice[4] = temp[0];
                dice[5] = temp[4];
                dice[1] = temp[5];
                break;
        }
    }

}
