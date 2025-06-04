package greedy.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S_1_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Grade[] grades = new Grade[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                grades[i] = new Grade(document, interview);
            }

            Arrays.sort(grades, Comparator.comparingInt((Grade g) -> g.document));
            int count = 1;
            int minInterview = grades[0].interview;

            for (int i = 1; i < N; i++) {
                if (grades[i].interview < minInterview) {
                    count++;
                    minInterview = grades[i].interview;
                }
            }
            System.out.println(count);
        }
    }

    public static class Grade {
        int document;
        int interview;

        public Grade(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
}
