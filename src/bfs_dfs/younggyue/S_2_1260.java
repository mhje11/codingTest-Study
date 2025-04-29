
package bfs_dfs.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S_2_1260 {
    //어려웠던점 : dfs 부분을 단순히 큐에서 스택으로 바꾸는게 아니라 작은 정점 부터 방문해야해서
    //추가적인 작업을 해야한다는 점을 몰랐음
    public static int N;
    public static int M;
    public static int V;
    public static List<Integer>[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                sb.append(node).append(" ");

            //작은 정점부터 방문 해야해서 역순으로 가야함
            List<Integer> neighbors = arr[node];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int next = neighbors.get(i);
                if (!visited[next]) {
                    stack.push(next);
                }
            }

            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int next : arr[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
