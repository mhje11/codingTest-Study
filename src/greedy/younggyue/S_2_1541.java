package greedy.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S_2_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        String[] groups = expression.split("-");
        int result = 0;

        for (int i = 0; i < groups.length; i++) {
            String group = groups[i];
            String[] numbers = group.split("\\+");

            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
