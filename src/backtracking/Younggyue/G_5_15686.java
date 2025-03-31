package backtracking.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G_5_15686 {
    public static int N, M;
    public static int[][] arr;
    public static List<int[]> storeCoordinate = new ArrayList<>();
    public static List<int[]> selectedStore = new ArrayList<>();
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    storeCoordinate.add(new int[]{i, j});
                }
            }
        }

        backtracking(0, 0);
        System.out.println(min);
    }

    public static void backtracking(int start, int depth) {
        if (depth == M) {
            int distance = chickenDistance();
            min = Math.min(min, distance);
            return;
        }

        for (int i = start; i < storeCoordinate.size(); i++) {
            selectedStore.add(storeCoordinate.get(i));
            backtracking(i + 1, depth + 1);
            selectedStore.remove(selectedStore.size() - 1);
        }

    }

    public static int chickenDistance() {
        int total = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    int dist = Integer.MAX_VALUE;
                    for (int[] store : selectedStore) {
                        int d = Math.abs(i - store[0]) + Math.abs(j - store[1]);
                        dist = Math.min(dist, d);
                    }
                    total += dist;
                }
            }
        }
        return total;
    }
}
