package sorting.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S_4_1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        Pair[] pairs = new Pair[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(A[i], i);
        }

        Arrays.sort(pairs, Comparator.comparingInt(p -> p.value));

        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[pairs[i].index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : P) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
