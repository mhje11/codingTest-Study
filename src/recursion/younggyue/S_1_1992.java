package recursion.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S_1_1992 {
    //어려웠던점 : 괄호의 처리를 어떻게 해야할지 몰라서 고생했음
    //원래는 탈출 조건마다 괄호를 닫으면 되는줄 알았는데 재귀전에 괄호를 열고 재귀를 호출후 괄호를 닫으면 되는거였음
    //이 문제또한 시간초과 문제때문에 StringBuilder 를 이용해야함
    public static int N;
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        recursion(0, 0, N);
        System.out.println(sb);
    }

    public static void recursion(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }
        int newSize = size / 2;
        sb.append("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recursion(x + i * newSize, y + j * newSize, newSize);
            }
        }
        //위의 반복문과 같음
//        // 순서 중요: 왼쪽 위 → 오른쪽 위 → 왼쪽 아래 → 오른쪽 아래
//        recursion(x, y, newSize); // 1사분면
//        recursion(x, y + newSize, newSize); // 2사분면
//        recursion(x + newSize, y, newSize); // 3사분면
//        recursion(x + newSize, y + newSize, newSize); // 4사분면
        sb.append(")");

    }

    public static boolean isSame(int x, int y, int size) {
        int num = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
