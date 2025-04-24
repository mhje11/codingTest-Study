package sorting.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_4_10825_V2 {
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

        Arrays.sort(scores);

        for (Score score : scores) {
            System.out.println(score.name);
        }
    }


    public static class Score implements Comparable<Score>{
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

        @Override
        public int compareTo(Score other) {
            if (this.language != other.language) {
                return other.language - this.language;
            }

            if (this.english != other.english) {
                return this.english - other.english;
            }

            if (this.math != other.math) {
                return other.math - this.math;
            }

            return this.name.compareTo(other.name);
        }
    }
}
