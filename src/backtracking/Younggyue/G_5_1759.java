package backtracking.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_5_1759 {
    public static int L, C;
    public static String[] alphabet;
    public static char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new String[C];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken();
        }
        Arrays.sort(alphabet);

        backtracking(0, 0, "");
        System.out.println(sb);
    }

    public static void backtracking(int start, int depth, String result) {
        if (depth == L) {
            if (checkVowel(result) && checkConsonant(result)) {
                sb.append(result).append('\n');
            }
            return;
        }
        for (int i = start; i < C; i++) {
            backtracking(i + 1, depth + 1, result + alphabet[i]);
        }

    }

    public static boolean checkVowel(String result) {
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            for (int j = 0; j < vowel.length; j++) {
                if (result.charAt(i) == vowel[j]) {
                    count++;
                }
            }
        }
        return count >= 1;
    }

    public static boolean checkConsonant(String result) {
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            boolean isVowel = false;
            for (char c : vowel) {
                if (result.charAt(i) == c) {
                    isVowel = true;
                    break;
                }
            }
            if (!isVowel) {
                count++;
            }
        }
        return count >= 2;
    }
}
