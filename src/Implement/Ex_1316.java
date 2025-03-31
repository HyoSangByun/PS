package Implement;

import java.util.Scanner;

public class Ex_1316 {

    static boolean[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int count = 0;

        for (int i = 0; i < N; i++) {
            ch = new boolean[26];
            String nextLine = sc.nextLine();
            ch[nextLine.charAt(0) - 'a'] = true;
            boolean flag = true;

            for (int j = 1; j < nextLine.length(); j++) {
                char c = nextLine.charAt(j);
                if (!ch[c - 'a']) ch[c - 'a'] = true;
                else { //기존에 있던 문자
                    if (nextLine.charAt(j - 1) != c) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) count++;
        }

        System.out.println(count);
    }

}

/*
    새로운 문자가 들어온 경우는 그냥 통과
    기존에 있던 문자인데 i - 1 번쨰 문자가 일치하면 오케이 다르면 break
 */