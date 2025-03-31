package String;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ex_01_06 { //중복문자제거
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String input1 = in.nextLine();
            StringBuilder sb = new StringBuilder();
            char[] charArray = input1.toCharArray();

            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for (char c : charArray) {
                set.add(c);
            }

            for (Character c : set) {
                sb.append(c);
            }

            String s = sb.toString();
            System.out.println(s);
        }
}

/*
indexOf() 로 문제 해결함
각 글자 자기 위치가 처음 발견한 위치가 같지 않다면?
중복문자라는 의미이다

str.indexOf(str.charAt(i)) == i <-- 중복 X
 */