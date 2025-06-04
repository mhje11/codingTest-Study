package greedy.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class G_4_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        int one = 0;
        int zero = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positive.add(num);
            } else if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else {
                negative.add(num);
            }
        }

        //양수는 그냥 큰수끼리 곱하고 남는거 더하기
        Collections.sort(positive, Collections.reverseOrder());
        for (int i = 0; i < positive.size(); i += 2) {
            if (i + 1 < positive.size()) {
                result += positive.get(i) * positive.get(i + 1);
            } else {
                result += positive.get(i);
            }
        }

        //음수끼리 곱해서 양수만들고 남는 음수는 0을 곱해서 0으로 무효화시키기, 남는 0은 그냥 더하면 됨
        Collections.sort(negative);
        for (int i = 0; i < negative.size(); i += 2) {
            if (i + 1 < negative.size()) {
                result += negative.get(i) * negative.get(i + 1);
            } else {
                if (zero > 0) {
                    zero--;
                } else {
                    result += negative.get(i);
                }
            }
        }
        //1은 더하는게 곱하는것보다 크니까 그냥 더하기
        result += one;

        System.out.println(result);
    }
}
