package Implement;

import java.util.Scanner;

public class Ex_9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        String delete = sc.next();
        int deleteLength = delete.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            sb.append(line.charAt(i));

            int sbLength = sb.length();
            if (sbLength >= deleteLength && sb.substring(sbLength - deleteLength).equals(delete)) {
                sb.delete(sbLength - deleteLength, sbLength);
            }
        }

        if (sb.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }


    }

}
