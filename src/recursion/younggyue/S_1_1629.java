package recursion.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_1_1629 {
    //어려웠던점 : 재귀가 어렵다기보다 수학적으로 접근해야해서 그 부분이 더 어려웠음
    public static long A;
    public static long B;
    public static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(recursion(A, B, C));
    }

    public static long recursion(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long half = recursion(a, b / 2, c);
        half = (half * half) % c;

        if (b % 2 == 1) {
            half = (half * a) % c;
        }
        return half;
    }
}
