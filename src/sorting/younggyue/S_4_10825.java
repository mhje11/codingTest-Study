package sorting.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S_4_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Score[] scores = new Score[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int language = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            scores[i] = new Score(name, language, english, math);
        }

        Arrays.sort(scores, (a, b) -> {
            if (a.language != b.language) {
                return b.language - a.language;
            }
            if (a.english != b.english) {
                return a.english - b.english;
            }
            if (a.math != b.math) {
                return b.math - a.math;
            }
            return a.name.compareTo(b.name);
        });

        for (Score score : scores) {
            System.out.println(score.name);
        }
    }


    public static class Score {
        String name;
        int language;
        int english;
        int math;

        public Score(String name, int language, int english, int math) {
            this.name = name;
            this.language = language;
            this.english = english;
            this.math = math;
        }
    }
}
