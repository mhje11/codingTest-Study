package backtracking.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_1_14888 {
    public static int N;
    public static int[] num;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, num[0]);
        System.out.println(max);
        System.out.println(min);

    }

    public static void backtracking(int depth, int result) {
        //숫자 N 개를 모두 써야 종료니까 기저조건은 depth == N
        //result 로 값을 누적하면서 재귀
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int next = calc(result, num[depth], i);
                backtracking(depth + 1, next);
                operator[i]++;
            }
        }
    }


    public static int calc(int a, int b, int op) {
        switch (op) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
        }
        return 0;
    }
}
