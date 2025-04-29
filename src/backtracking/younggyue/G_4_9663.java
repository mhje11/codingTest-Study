package backtracking.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G_4_9663 {
    //어려웠던점 : 백트래킹을 가능성을 생각하면서 진행해야 하는데 아무 생각없이 모든경우를 다 돌리고 검사하는 방향으로 생각
    //그 외 어려웠던점은 풀어본 경험이 있어서 크게 없었음
    public static int N;
    public static int[] arr;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        backtracking(0);
        System.out.println(count);
    }

    public static void backtracking(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (possibility(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    public static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
