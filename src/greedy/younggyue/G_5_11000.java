package greedy.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G_5_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new int[]{s, t});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] time : list) {
            int start = time[0];
            int end = time[1];
            if (!queue.isEmpty() && queue.peek() <= start) {
                queue.poll();
            }
            queue.add(end);
        }
        System.out.println(queue.size());
    }
}
