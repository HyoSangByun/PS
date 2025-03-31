package Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_14719 {

    static int H, W;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        map = new int[H][W];

        for (int y = 0; y < W; y++) {
            int block_height = sc.nextInt();

            for (int x = 0; x < block_height; x++) {
                map[H - x - 1][y] = 1;
            }
        }

//        for (int i = 0; i < H; i++) {
//            System.out.println();
//            for (int j = 0; j < W; j++) {
//                System.out.print(map[i][j]);
//            }
//        }
//        System.out.println();

        fill(0);

//        for (int i = 0; i < H; i++) {
//            System.out.println();
//            for (int j = 0; j < W; j++) {
//                System.out.print(map[i][j]);
//            }
//        }
//        System.out.println();

        System.out.println(answer);
    }

    private static void fill(int L) {
        if (L == H) return;

        int lp = -1;
        int rp = -2;
        for (int i = 0; i < W; i++) {
            if (map[H - L - 1][i] == 1) {
                lp = i + 1;
                break;
            }
        }

        for (int i = W - 1; i >= 0; i--) {
            if (map[H - L - 1][i] == 1) {
                rp = i;
                break;
            }
        }
//        System.out.println(L + ":" + lp + " " + rp);

        while ( lp < rp) {
            if (map[H - L - 1][lp] == 0) {
                map[H - L - 1][lp] = 1;
                lp++;
                answer++;
            }
            else lp++;
        }

        fill(L + 1);
    }
}

/*
이런 방법도 있음.
https://moonsbeen.tistory.com/247

현재 블록의 높이보다 높은 블록이 왼쪽에 있어야 한다.
현재 블록의 높이보다 높은 블록이 오른쪽에 있어야 한다.
첫, 마지막 블록에는 빗물이 고일 수 없다.

인덱스 별로 모이는 빗물의 정보를 더해준 다음 출력해주면 된다.
현재 인덱스를 기준으로 왼쪽에서 가장 높은 블럭과 오른쪽에서 가장 높은 블럭을 구해준 다음,
현재 블럭이 두 블럭보다 낮은지 확인 후,
둘 중에 더 낮은 기둥을 기준으로 낮은 기둥에서 현재 기둥높이를 빼 주어 빗물이 고일 수 있는 높이를 계산해 주었다.
 */