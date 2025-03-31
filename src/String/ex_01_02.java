package String;

import java.util.Scanner;

public class ex_01_02 { //대소문자 변환
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input1 = in.next();

        StringBuilder sb = new StringBuilder();

        char[] charArray = input1.toCharArray();

        for (char c : charArray) {
            if(Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        String answer = sb.toString();
        System.out.println(answer);
    }
}

/*
대문자는 아스키코드 65~90
소문자는 97~122
32를 빼면 변환가능하다
*/