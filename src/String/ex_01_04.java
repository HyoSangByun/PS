package String;

import java.util.ArrayList;
import java.util.Scanner;

public class ex_01_04 { //단어 뒤집기
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        String[] str = new String[n];
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }

        for (String s : str) {
            String answer = new StringBuilder(s).reverse().toString();
            list.add(answer);
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

//String.valueOf(character array)