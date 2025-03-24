package recursion.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G_5_11729 {
    //어려웠던점 : 하노이탑의 재귀 과정을 이해하는게 까다로웠음
    //재귀 과정이 가장 큰원판을 옮기고 n - 1 개의 원판의 위치를 원상복귀 시키는 형식의 재귀인데 파악이 어려웠었음
    //또한 println 을 사용하면 시간초과가 되는 문제 때문에 StringBuilder 를 사용해야 했음
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println((int) Math.pow(2, N) - 1);
        recursion(N, 1, 2, 3);
        System.out.println(sb);
    }

    public static void recursion(int n, int from, int via, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append('\n');
            return;
        }

        recursion(n - 1, from, to, via);
        sb.append(from).append(" ").append(to).append('\n');
        recursion(n - 1, via, from, to);
    }
}
