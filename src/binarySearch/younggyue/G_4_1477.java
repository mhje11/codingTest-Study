package binarySearch.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_4_1477 {
    //고속도로 시작(0) ~ 첫휴게소 거리
    //마지막 휴게소 ~ 고속도로 끝 거리
    //휴게소들 사이의 거리
    // 위 3개의 경우를 각각 mid(허용해볼 휴게소간 거리)로 나눠서 필요한 휴게소수 계산
    // -1 을 해주는 이유는 mid가 200 일때 200 / 200 일경우 한개가 필요한것 같지만 사실은 휴게소가 필요없으므로 -1 을해줘서 해당 경우를 0으로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        //N이 0일경우 인덱스 오류뜸
        if (N == 0) {
            int left = 1;
            int right = L - 1;
            int answer = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                int count = (L - 1) / mid;
                if (count > M) {
                    left = mid + 1;
                } else {
                    answer = mid;
                    right = mid - 1;
                }
            }
            System.out.println(answer);
            return;
        }
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch(arr, L, M));
    }

    public static int binarySearch(int[] arr, int L, int M) {
        int min = 0;
        int left = 1;
        int right = L - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            count += (arr[0] - 1) / mid;

            for (int i = 1; i < arr.length; i++) {
                count += (arr[i] - arr[i - 1] - 1) / mid;
            }

            count += (L - arr[arr.length - 1] - 1) / mid;

            if (count > M) {
                left = mid + 1;
            } else {
                min = mid;
                right = mid - 1;
            }
        }
        return min;
    }
}
