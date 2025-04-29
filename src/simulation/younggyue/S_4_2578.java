package simulation.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class S_4_2578 {
    public static int[][] bingo = new int[5][5];
    public static int[][] call = new int[5][5];
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                call[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bingo();
    }

    public static void bingo() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int current = call[i][j];
                count++;
                erase(current);
                if (isBingo()) {
                    System.out.println(count);
                    return;
                }
            }
        }



    }

    public static void erase(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num) {
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }


    public static boolean isBingo() {
        int line = 0;

        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                line++;
            }
        }

        for (int j = 0; j < 5; j++) {
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                if (bingo[i][j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                line++;
            }
        }

        boolean flag = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] != 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            line++;
        }


        flag = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 -i] != 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            line++;
        }
        return line >= 3;
    }
}
