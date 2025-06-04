package greedy.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G_5_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        StringBuilder sb = new StringBuilder(t);

        while (sb.length() > s.length()) {
            if (sb.charAt(sb.length() - 1) == 'B') {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        if (sb.toString().equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
