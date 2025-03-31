package String;

import java.util.Scanner;

public class ex_01_05 { //특정 문자 뒤집기 !못품
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();  // next() -> nextLine()로 변경하여 공백도 포함 가능
        char[] chars = input1.toCharArray();

        // 1. 알파벳만 추출해서 stringBuilder 에 넣기
        StringBuilder letters = new StringBuilder();
        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                letters.append(c);
            }
        }

        // 알파벳 뒤집기
        letters.reverse();
        int letterIndex = 0;

        // 2. 원래 위치에 알파벳 다시 배치
        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                chars[i] = letters.charAt(letterIndex);
                letterIndex++;
            }
        }

        String answer = new String(chars);
        System.out.println(answer);
    }
}

/*
lt, rt가 각각 특수문자면 넘어가고
둘다 알파벳이면 서로 swap하는 방식으로 해결함
 */