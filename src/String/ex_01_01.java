package String;

import java.util.Scanner;

public class ex_01_01 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        String input1LowerCase = input1.toLowerCase();
        String input2LowerCase = input2.toLowerCase();

        char c = input2LowerCase.charAt(0);
        char[] charArray = input1LowerCase.toCharArray();

        int answer = 0;

        for (char c1 : charArray) {
            if(c1 == c) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
