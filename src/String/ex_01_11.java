package String;

import java.util.Scanner;

public class ex_01_11 { //문자열 압축 !못품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] charArray = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        int n = 1;
        boolean key = false;
        for (int i = 0; i < input.length() -1; i++) {
            //(i != input.length()) &&
            if ( (input.charAt(i) == input.charAt(i+1)) ) {
                n++;
                key = true;
            } else {
                sb.append(input.charAt(i));
                if (key) {
                    sb.append(n);
                }
                n=1;
                key = false;
            }
        }
        String answer = sb.toString();
        System.out.println(answer);

    }

}

/*
로직은 비슷함
 */