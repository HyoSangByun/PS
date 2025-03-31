package String;

import java.util.Scanner;

public class ex_01_09 { //숫자만 추출
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        String s1 = sb.toString();
        int key = 0;

        if(s1.charAt(0) == '0') {
            for (int i = 1; i < s1.length(); i++) {
                if (s1.charAt(i) != '0') {
                    key= i;
                    break;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i = key; i < s1.length(); i++) {
                sb2.append(s1.charAt(i));
            }
            String answer = sb2.toString();
            System.out.println(answer);
        } else {
            System.out.println(s1);
        }

    }
}

/*
아스키코드 48 ~ 57 이면 문자형 숫자라는 뜻
0=48, 57=9

answer = answer * 10 + (x-48)
------------------------
"0208"을 parseInt 해주면 208이 됨

 */