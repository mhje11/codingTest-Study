package bfs_dfs.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S_3_2606 {
    //어려웠던점 : S_2_1260 과 유사한 문제여서 딱히 어려운점 없었음
    public static int N;
    public static int V;
    public static boolean[] isVisit;

    public static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());
        arr = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        isVisit = new boolean[N + 1];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        bfs();
        int count = 0;
        for (int i = 0; i < isVisit.length; i++) {
            if (isVisit[i]) {
                count++;
            }
        }
        System.out.println(count - 1);

    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        isVisit[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : arr[node]) {
                if (!isVisit[next]) {
                    isVisit[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
