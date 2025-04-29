package binarySearch.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_2_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] snack = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            snack[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(snack);

        System.out.println(binarySearch(snack, M));
    }

    public static long binarySearch(long[] snack, int M) {
        long left = 1;
        long right = snack[snack.length - 1];
        long max = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long result = 0;
            for (int i = 0; i < snack.length; i++) {
                result += snack[i] / mid;
            }
            if (result >= M) {
                left = mid + 1;
                max = mid;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }
}
