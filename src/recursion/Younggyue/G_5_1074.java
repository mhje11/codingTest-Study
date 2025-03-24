package recursion.Younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_5_1074 {
    //어려웠던점 : 배열을 채워나가면서 진행해야 하는줄 알았지만 사분면 마다 일정 횟수만큼 지나가기 때문에
    //반복문 대신 사분면을 나눠서 따로따로 num 을 누적시켜서 계산
    //size == 1 이 탈출 조건인 이유는 더이상 1일때 쪼갤 수 없기 때문
    public static int N;
    public static int r;
    public static int c;
    public static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        recursion(0, 0, size);
        System.out.println(num);
    }

    public static void recursion(int x, int y, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 2;

        if (r < x + newSize && c < y + newSize) {
            recursion(x, y, newSize);
        } else if (r < x + newSize && c >= y + newSize) {
            num += newSize * newSize;
            recursion(x, y + newSize, newSize);
        } else if (r >= x + newSize && c < y + newSize) {
            num += 2 * newSize * newSize;
            recursion(x + newSize, y, newSize);
        } else {
            num += 3 * newSize * newSize;
            recursion(x + newSize, y + newSize, newSize);
        }
    }
}
