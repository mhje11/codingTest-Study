package binarySearch.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_2_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(binarySearch(arr, M));
    }

    public static long binarySearch(long[] arr, long target) {
        long left = 1;
        long right = arr[arr.length - 1];
        //max 를 Long.Min_VALUE 로 하면 최소가 0 일경우가 틀려버림 그래서 0써야함
        long max = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long result = 0;
            for (int i = 0; i < arr.length; i++) {
                long height = arr[i] - mid;
                if (height < 0) {
                    height = 0;
                }
                result += height;
            }
            if (result >= target) {
                max = Math.max(mid, max);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }
}
