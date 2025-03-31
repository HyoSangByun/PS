package Implement;

import java.util.Scanner;

public class Ex_1193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int cross_count = 1; //현재 대각의 칸 개수
        int prev_count_sum = 0; //이전까지의 대각선의 모든 칸 개수

        while (true) {
            if (X <= cross_count + prev_count_sum) {
                //현재 대각선의 개수가 짝수라면
                if (cross_count % 2 == 0) {
                    //분자
                    int son = X - prev_count_sum;
                    //분모
                    int mother = cross_count - (X - prev_count_sum - 1);
                    System.out.println(son + "/" + mother);
                    break;
                }
                //현재 대각선의 개수가 홀수라면
                else {
                    //분자
                    int son = cross_count - (X - prev_count_sum - 1);
                    //분모
                    int mother = X - prev_count_sum;
                    System.out.println(son + "/" + mother);
                    break;
                }

            }
            else {
                prev_count_sum += cross_count;
                cross_count++;
            }
        }
    }

}

/*
    내가 푼건 아님. Stranger's lab 참고함.

    대각선의 개수가 짝수면 분수가 증가하는 형태
    대각선의 개수가 홀수면 분수가 감소하는 형태
 */