package sorting.younggyue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class S_5_5648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Long> list = new ArrayList<>();
        while (list.size() < n) {
            String token = sc.next();
            String reversed = new StringBuilder(token).reverse().toString();
            list.add(Long.parseLong(reversed));
        }

        Collections.sort(list);

        for (Long l : list) {
            System.out.println(l);
        }
    }
}
