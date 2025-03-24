package recursion.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G_5_2447 {
    //어려웠던점 : 시작부터 도저히 어떻게 해야할지 갈피도 못잡았던 문제인데
    //3 x 3 으로 나눈 정사각형에서 가운데 구역은 공백으로 처리해야해서 i == 1 && j == 1 일때 fillBlank() 호출
    //왜냐? 9등분중 가운데 부분이니까 나머지 구역은 재귀하며 size == 1 이면 더이상 쪼갤 수 없으므로 탈출
    public static int N;
    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        StringBuilder sb = new StringBuilder();
        recursion(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void recursion(int x, int y, int size) {
        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    fillBlank(x + i * newSize, y + j * newSize, newSize);
                } else {
                    recursion(x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }

    public static void fillBlank(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                arr[i][j] = ' ';
            }
        }
    }
}
