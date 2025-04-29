package stack.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S_4_10828 {
    // 풀면서 어려웠던점 : 간단한 스택 구현이라 크게 어려운 점은 없었다. 스택 구현을 해본적이 없었다면 배열을 사용해서 풀어봤을듯 하다.
    // 그나마 어려웠던 부분이라 해도 push 이후 정수를 어떻게 받아 낼것인지 여러 방법이 있지만 String.split() 을 이용했다.
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
