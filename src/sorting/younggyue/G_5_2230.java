package sorting.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_5_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;

        Arrays.sort(arr);

        while (right < N && left < N) {
            int diff = arr[right] - arr[left];

            if (diff < M) {
                right++;
            } else {
                result = Math.min(result, diff);
                left++;
            }

        }
        System.out.println(result);
    }
}
