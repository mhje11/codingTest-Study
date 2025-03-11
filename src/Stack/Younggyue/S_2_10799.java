package Stack.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S_2_10799 {
    //풀면서 어려웠던점 : 레이저와 막대의 끝부분을 구분하는것
    //막대의 끝부분일 경우 어떻게 계산해야하는지 끝부분일 경우 잘린조각 하나가 추가되는것이기 때문에 단순히 count++
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                //레이저일경우 스택의 크기(막대의 갯수)
                if (s.charAt(i - 1) == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    //막대의 끝부분일 경우
                    stack.pop();
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
