package greedy.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 1;
        while (b > a) {
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b /= 10;
            } else {
                break;
            }
            count++;
        }
        System.out.println(b == a ? count : -1);
    }
}
