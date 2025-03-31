package String;

import java.util.Scanner;

public class ex_01_03 { //문장 속 단어
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();

        String[] split = input1.split(" ");

        String answer = "";
        for (String s : split) {
            if(s.length() > answer.length()) {
                answer = s;
            }
        }

        System.out.println(answer);
    }
}
