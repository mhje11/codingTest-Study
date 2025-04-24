package sorting.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G_5_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        list.sort(Comparator.comparingInt(a -> a[0]));

        int total = 0;
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for (int i = 1; i < N; i++) {
            int[] current = list.get(i);
            int x = current[0];
            int y = current[1];

            if (x <= end) {
                end = Math.max(end, y);
            } else {
                total += end - start;
                start = x;
                end = y;
            }
        }

        total += end - start;
        System.out.println(total);
    }
}
