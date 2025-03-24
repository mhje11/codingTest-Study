package recursion.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2_1780 {
    //어려웠던점 : 전형적인 분할정복 문제라 크게 어렵지 않았음
    public static int N;
    public static int[][] arr;
    public static int[] count = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }

    }

    public static void recursion(int x, int y, int size) {
        if (isSameNumber(x, y, size)) {
            count[arr[x][y] + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recursion(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    public static boolean isSameNumber(int x, int y, int size) {
        int num = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
