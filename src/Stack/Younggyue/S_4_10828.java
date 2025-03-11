package Stack.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S_4_10828 {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push ")) {
                String[] split = command.split(" ");
                push(Integer.valueOf(split[1]));
            } else if (command.equals("pop")) {
                pop();
            } else if (command.equals("size")) {
                size();
            } else if (command.equals("empty")) {
                isEmpty();
            } else if (command.equals("top")) {
                top();
            }
        }
    }

    public static void push(int num) {
        stack.push(num);
    }

    public static void pop() {
        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        } else {
            System.out.println("-1");
        }
    }

    public static void size() {
        System.out.println(stack.size());
    }

    public static void isEmpty() {
        if (stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void top() {
        if (!stack.isEmpty()) {
            System.out.println(stack.peek());
        } else {
            System.out.println(-1);
        }
    }
}
