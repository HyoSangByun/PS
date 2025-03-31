package Swea;

import java.util.Scanner;

public class Ex_1974 {
    static int[][] map;
    static boolean ch[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean flag = true;

        //세로 확인
        for (int i = 0; i < 9; i++) {
            if (!row(i)) {
                flag = false;
                break;
            }
        }

        //가로 확인
        if (flag) {
            for (int i = 0; i < 9; i++) {
                if (!col(i)) {
                    flag = false;
                    break;
                }
            }
        }

        //네모판 확인
        //0 3 6
        if (flag) {
            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    if (!box(i,j)) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean row(int num) {
        ch  = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int value = map[num][i];
            if (!ch[value]) {
                ch[value] = true;
            }
            else {
                return false;
            }
        }

        return true;
    }

    private static boolean col(int num) {
        ch  = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int value = map[i][num];
            if (!ch[value]) {
                ch[value] = true;
            }
            else {
                return false;
            }
        }

        return true;
    }

    private static boolean box(int x, int y) {
        ch = new boolean[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                int value = map[i][j];

                if (!ch[value]) {
                    ch[value] = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
