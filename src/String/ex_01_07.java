package String;

import java.util.Scanner;

public class ex_01_07 { //회문 문자열(앞에서 읽으나 뒤에서 읽으나 같은 문자열)
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String input1 = in.nextLine().toLowerCase();
            String input1Reverse = new StringBuilder(input1).reverse().toString();

            char[] input1CharArray = input1.toCharArray();
            char[] input1ReverseCharArray = input1Reverse.toCharArray();

            solution(input1CharArray, input1ReverseCharArray);
        }

    private static void solution(char[] input1CharArray, char[] input1ReverseCharArray) {
        boolean answer = true;
        for (int i = 0; i < input1CharArray.length; i++) {
            if(!(input1CharArray[i] == input1ReverseCharArray[i])) {
                answer = false;
            }
        }
        if (answer == true) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
