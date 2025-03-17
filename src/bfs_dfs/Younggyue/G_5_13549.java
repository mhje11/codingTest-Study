package bfs_dfs.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_5_13549 {
    //어려웠던점 : 우선 그리디나 수학으로 풀 수 있을거 같은 느낌이라 알고리즘을 보고도 bfs란게 잘 납득이 안됐었음
    //단순히 2차원 평면에서 어떻게 bfs를 처리할지를 잘 몰랐음, 노드, 2차원 좌표계의 유형이 아닌 새로보는 유형이라 구현에 어려움도 겪음
    //그리디가 안되는 이유 : 그리디는 항상 가장 좋은 선택을 한다를 전제로 푸는 방법 하지만 뒤로 갔다가 순간이동 하는게 더 빠를 수 도있고
    //단순히 순간이동만으로는 도달할 수 없을 경우가 있음
    //수학적으로 불가능한 이유 : 순간이동(2 * X)이 존재해서 단순한 수열문제로 변환 불가
    public static boolean[] visited;
    public static int min = Integer.MAX_VALUE;
    public static int N;
    public static int K;
    public static int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];

        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            visited[position] = true;

            if (position == K) {
                min = Math.min(min, time);
            }

            //순간이동은 시간이 걸리지 않으므로 가장 먼저 연산해야함
            if (position * 2 <= max && !visited[position * 2]) {
                queue.offer(new int[]{position * 2, time});
            }

            if (position + 1 <= max && !visited[position + 1]) {
                queue.offer(new int[]{position + 1, time + 1});
            }

            if (position - 1 >= 0 && !visited[position - 1]) {
                queue.offer(new int[]{position - 1, time + 1});
            }
        }

    }
}
