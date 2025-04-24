package simulation.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G_3_17471 {
    public static int N;
    public static List<Integer>[] arr;
    public static int[] people;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        arr = new List[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int neighbor = Integer.parseInt(st.nextToken()) - 1;
                arr[i].add(neighbor);
                arr[neighbor].add(i);
            }
        }

        backtracking(0, new boolean[N]);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    public static void backtracking(int depth, boolean[] groupA) {
        if (depth == N) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (groupA[i]) {
                    a.add(i);
                } else {
                    b.add(i);
                }
            }

            if (a.isEmpty() || b.isEmpty()) {
                return;
            }

            if (isConnected(a) && isConnected(b)) {
                int sumA = a.stream().mapToInt(i -> people[i]).sum();
                int sumB = b.stream().mapToInt(i -> people[i]).sum();
                min = Math.min(min, Math.abs(sumA - sumB));
            }
            return;
        }

        groupA[depth] = true;
        backtracking(depth + 1, groupA);

        groupA[depth] = false;
        backtracking(depth + 1, groupA);
    }

    public static boolean isConnected(List<Integer> group) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : arr[current]) {
                if (group.contains(next) && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count == group.size();
    }
}
