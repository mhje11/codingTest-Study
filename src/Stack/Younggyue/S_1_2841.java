package Stack.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S_1_2841 {
    public static int N;
    public static int P;

    //풀면서 어려웠던 점 : 음마다 스택이 필요하다는 점을 간과하고 진행했었다.
    // 이후 스택 배열을 구현하면 되는데 그 구현 방식이 생각나지 않아 시간을 잡아 먹음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            stacks[i] = new Stack<>();
        }

        int totalMoves = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int note = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            // 해당 음에서 현재 프렛보다 낮은 프렛을 누를경우 stack 에 있는 프렛들을 모두 pop
            while (!stacks[note].isEmpty() && stacks[note].peek() > fret) {
                stacks[note].pop();
                totalMoves++;
            }

            // 해당 음에서 현재 프렛보다 더 높은 프렛을 누르거나 스택이 비어있으면 push
            if (stacks[note].isEmpty() || stacks[note].peek() != fret) {
                stacks[note].push(fret);
                totalMoves++;
            }
        }
        System.out.println(totalMoves);

    }
}
