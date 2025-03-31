package Swea;

import java.util.Scanner;

public class Ex_1220 {

    //1은 N극, 2는 S극 테이블 위는 N극, 아래는 S극
    public static void main(String[] args) {
        for (int test_case = 1; test_case <= 10; test_case++) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            for(int i=0; i<100; i++) {
                int last = 0;

                for(int j=0; j<100; j++) {
                    if(arr[j][i] == 1) {// N극 이면
                        last = 1;
                    }
                    else if(arr[j][i] == 2) {// S극 이면
                        if(last == 1) {
                            sum++;
                        }
                        last = 2;
                    }
                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }

}
