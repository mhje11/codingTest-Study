package binarySearch.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_2_1654 {
    //정수범위를 넘어서 long 써야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        System.out.println(binarySearch(arr, N));
    }

    public static long binarySearch(int[] arr, int N) {
        long max = Long.MIN_VALUE;
        long left = 1;
        long right = arr[arr.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }

            if (count >= N) {
                max = Math.max(mid, max);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }
}
