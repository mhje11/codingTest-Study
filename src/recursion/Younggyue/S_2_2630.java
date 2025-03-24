package recursion.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2_2630 {
    //어려웠던점 : 오랜만에 푼 분할정복 + 재귀라 구현에서 어려움을 겪음
    //사분면을 나눠서 생각하는 부분이 어떻게 처리해야할지 헷갈렸음
    public static int N;
    public static int[][] arr;
    public static int[] count = new int[2];

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
        for (int i : count) {
            System.out.println(i);
        }
    }

    public static void recursion(int x, int y, int size) {
        if (isSame(x, y, size)) {
            count[arr[x][y]]++;
            return;
        }
        int newSize = size / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recursion(x + i * newSize, y + j * newSize, newSize);
            }
        }

    }

    public static boolean isSame(int x, int y, int size) {
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
