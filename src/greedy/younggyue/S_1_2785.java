package greedy.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1_2785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] links = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            links[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(links);

        int count = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            count = N - i - 1;
            sum += links[i];

            if (sum >= count) {
                break;
            }
        }
        System.out.println(count);
    }
}
