package Two_pointers_Sliding_window;

import java.util.Scanner;

public class Ex_03_05 { //연속 부분수열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count=0;
        for (int i = 1; i <= (n/2) ; i++) {
            int sum = i;
            for (int j = i+1; j < n; j++) {
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}

/*
얘도 앞선 문제와 마찬가지로 투 포인터 슬라이딩 방법으로 풀었음
 */

/*
수학적 접근 방법
    int answer = 0, cnt = 1;
    n--;
    while(n>0) {
        cnt++;
        n=n-cnt;
        if(n%cnt == 0) answer++;
 */