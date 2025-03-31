package String;

import java.util.ArrayList;
import java.util.Scanner;

public class ex_01_12 { //암호
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int k = 7 * i;
            String substring = input.substring(k, k + 7);
            list.add(substring);
        }

        for (String s : list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '#') {
                    sb.append(1);
                }else sb.append(0);
            }
            char c = (char) Integer.parseInt(sb.toString(), 2);
            answer.append(c);
        }
        System.out.println(answer.toString());

//        String binaryString = "1101";
//        int decimalValue = Integer.parseInt(binaryString, 2);

    }

}
