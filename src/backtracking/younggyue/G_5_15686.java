package backtracking.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G_5_15686 {
    //어려웠던점 : 재귀 과정에서 선택된 치킨집을 제거하는것을 고려하지 않았었음
    //제거가 아니라 초기화를 해버려서 제대로된 정답이 나오지 않음 재귀과정을 생각하면
    //좌표 A, B, C, D 에 M = 2 라고 가정하면 [A,B], [A,C], [A,D] 이렇게 A를 선택한후 A의 하위과정이 끝나면 A가 remove 돼고 i 인덱스에 따라
    //다음 좌표인 B로 넘어가는 부분을 헷갈림
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
