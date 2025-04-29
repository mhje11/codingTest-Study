package sorting.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_3_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arrA = new int[n];
            int[] arrB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int count = 0;
            for (int i = 0; i < arrA.length; i++) {
                count += binarySearch(arrB, arrA[i]);
            }
            System.out.println(count);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int count = 0;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return count;
    }
}
