package Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_14891 {

    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= 5; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 1; i <= 4; i++) {
            String nextLine = sc.nextLine();
            for (int j = 0; j < nextLine.length(); j++) {
                lists.get(i).add(nextLine.charAt(j) - '0');
            }
        }

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int index = sc.nextInt();
            int direction = sc.nextInt();

            ch = new boolean[5];
            rotate(index, direction);
        }

        int answer = 0;
        if (lists.get(1).get(0) == 1) answer += 1;
        if (lists.get(2).get(0) == 1) answer += 2;
        if (lists.get(3).get(0) == 1) answer += 4;
        if (lists.get(4).get(0) == 1) answer += 8;

        System.out.println(answer);
    }

    private static void rotate(int index, int direction) {
        ch[index] = true;

        boolean rotateRight = false;
        boolean rotateLeft = false;

        //오른쪽 톱니바퀴 확인
        if (index + 1 <= 4 && !ch[index + 1] && lists.get(index).get(2) != lists.get(index+ 1).get(6)) {
            rotateRight = true;
        }

        //왼쪽 톱니바퀴 확인
        if (index - 1 >= 1 && !ch[index - 1] && lists.get(index).get(6) != lists.get(index - 1).get(2)) {
            rotateLeft = true;
        }

        if (direction == 1) {//시계 방향
            Integer removed = lists.get(index).remove(7);
            lists.get(index).addFirst(removed);
        } else {
            Integer removed = lists.get(index).remove(0);
            lists.get(index).addLast(removed);
        }

        if(rotateLeft) rotate(index - 1, direction * -1);
        if(rotateRight) rotate(index + 1, direction * -1);
    }

}

/*
    톱니바퀴에 왼쪽 부분은 index 6
    오른쪽 부분은 2

    시계방향
    10101111
    11010111

    반시계방향
    10101111
    01011111
 */