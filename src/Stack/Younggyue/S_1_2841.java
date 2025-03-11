package Stack.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S_1_2841 {
    public static int N;
    public static int P;

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

            while (!stacks[note].isEmpty() && stacks[note].peek() > fret) {
                stacks[note].pop();
                totalMoves++;
            }

            if (stacks[note].isEmpty() || stacks[note].peek() != fret) {
                stacks[note].push(fret);
                totalMoves++;
            }
        }
        System.out.println(totalMoves);

    }
}
