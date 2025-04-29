package binarySearch.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_4_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, C));
    }

    //공유기가 C개 이상이어도 되는 이유는 오히려 C개 이상이면 거리에 여유가 있으니까 거리를 더 늘려봐도 댐
    public static int binarySearch(int[] arr, int C) {
        int left = 1;
        int right = arr[arr.length - 1] - arr[0];
        int max = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int last = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - last >= mid) {
                    count++;
                    last = arr[i];
                }
            }
            if (count >= C) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }
}
