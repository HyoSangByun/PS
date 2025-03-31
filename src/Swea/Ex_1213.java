package Swea;

import java.util.Scanner;

public class Ex_1213 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();
        sc.nextLine();

        String find = sc.nextLine().trim();
        String line = sc.nextLine().trim();
        int length = find.length();

        int answer = 0;
        for (int i = 0; i < line.length() - length + 1; i++) {
            String substring = line.substring(i, i + length);
//            System.out.println(substring);
            if (substring.equals(find)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
