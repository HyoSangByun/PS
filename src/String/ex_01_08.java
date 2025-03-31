package String;

import java.util.Scanner;

public class ex_01_08 { //팰린드롬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String inputLowerCase = input.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputLowerCase.length(); i++) {
            if (Character.isAlphabetic(inputLowerCase.charAt(i))) {
                sb.append(inputLowerCase.charAt(i));
            }
        }
        String s1 = sb.toString();
        String s2 = new StringBuilder(s1).reverse().toString();

        if (s1.equals(s2)) {
            System.out.println("YES");
        } else System.out.println("NO");

    }
}

/*
String.replaceAll("[^A-Z]", "")
A-Z가 아니면 ""로 대체한다는 뜻
^는 부정표현
 */