package simulation.younggyue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G_5_14891 {
    //어려웠던점 : 기준이되는 톱니를 제외한 나머지 톱니의 방향을 배열로 정하고 인덱스로 깔끔하게 관리하는 법이 생각이 안났었음
    public static List<Deque<Integer>> gears = new ArrayList<>();
    public static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            Deque<Integer> gear = new LinkedList<>();
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear.addLast(line.charAt(j) - '0');
            }
            gears.add(gear);
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotateGear(gearNum - 1, dir);
        }

        for (int i = 0; i < 4; i++) {
            if (gears.get(i).peekFirst() == 1) {
                score += (int) Math.pow(2, i);
            }
        }

        System.out.println(score);
    }

    public static void rotateGear(int gear, int dir) {
        int[] rotateDir = new int[4];
        rotateDir[gear] = dir;

        for (int i = gear - 1; i >= 0; i--) {
            if (gears.get(i + 1).toArray()[6] != gears.get(i).toArray()[2]) {
                rotateDir[i] = -rotateDir[i + 1];
            } else {
                break;
            }
        }

        for (int i = gear + 1; i < 4; i++) {
            if (gears.get(i - 1).toArray()[2] != gears.get(i).toArray()[6]) {
                rotateDir[i] = -rotateDir[i - 1];
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (rotateDir[i] == 1) {
                clockwise(gears.get(i));
            } else if (rotateDir[i] == -1) {
                counterClockwise(gears.get(i));
            }
        }
    }


    public static void clockwise(Deque<Integer> deque) {
        deque.addFirst(deque.pollLast());
    }

    public static void counterClockwise(Deque<Integer> deque) {
        deque.addLast(deque.pollFirst());
    }
}
