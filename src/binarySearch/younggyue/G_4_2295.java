package binarySearch.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class G_4_2295 {
    // a + b + c = k 이지만 이분탐색을 위해 식을 변형
    // b + c = k - a
    // 이제 b + c 를 미리 저장해두고 k - a를 target 으로 이분탐색을 진행
    public static List<Integer> list = new ArrayList<>();
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                list.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(list);

        int max = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int k = arr[i];
                int a = arr[j];
                int target = k - a;
                if (Collections.binarySearch(list, target) >= 0) {
                    max = Math.max(max, k);
                }
            }
        }
        System.out.println(max);
    }

}
