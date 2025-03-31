package greedy.baekjoon;

import java.util.Scanner;

public class Ex_08 { //백준 1789
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int i = 1;
        long sum = 0;
        int count = 0;
        while (true) {
            if (sum > N) break;
            sum += i;
            count++;
            i++;
        }

        System.out.println(count -1);
        sc.close();
    }
}

// 10 : 1 + 2 + 3
// 11 : 1 + 2 + 3 + 5