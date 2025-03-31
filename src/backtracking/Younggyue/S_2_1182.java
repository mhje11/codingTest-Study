package backtracking.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2_1182 {
    //오답인 코드 + 시간초과, 중복 체크를 굳이 할필요없으므로 visited 배열도 필요 없음
    //또한 start + 1이 아니라 i + 1 로 했어야함
    //result 를 저런식으로 누적하면 나중에 재귀할때 원하는 값이 안들어감
    public static int N, S;
    public static int[] arr;
    public static int count = 0;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);
        System.out.println(count);

    }

    public static void backtracking(int start, int result) {
        if (result == S) {
            count++;
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(start + 1, result += arr[i]);
                visited[i] = false;
            }
        }
    }
}
