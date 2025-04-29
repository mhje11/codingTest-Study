package binarySearch.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_4_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr2 = new int[M];

        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr1);

        for (int i = 0; i < arr2.length; i++) {
            if (binarySearch(arr2[i], arr1)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] == target){
                return true;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
