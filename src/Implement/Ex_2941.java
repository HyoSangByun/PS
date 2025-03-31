package Implement;

import java.util.Scanner;

public class Ex_2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        StringBuilder sb = new StringBuilder(nextLine);
        String sbString = sb.append("  ").toString();
        int count = 0;

        for (int i = 0; i < nextLine.length(); i++) {
//            System.out.println(i);
            if (nextLine.charAt(i) == 'c') {
                if (sbString.charAt(i + 1) == '=') i++;
                else if (sbString.charAt(i + 1) == '-') i++;
                count++;
            }
            else if (nextLine.charAt(i) == 'd') {
                if (sbString.charAt(i + 1) == 'z' && sbString.charAt(i + 2) == '=') i += 2;
                else if (sbString.charAt(i + 1) == '-') i++;
                count++;
            } else if (nextLine.charAt(i) == 'l') {
                if (sbString.charAt(i + 1) == 'j') i++;
                count++;
            } else if (nextLine.charAt(i) == 'n') {
                if (sbString.charAt(i + 1) == 'j') i++;
                count++;
            } else if (nextLine.charAt(i) == 's') {
                if (sbString.charAt(i + 1) == '=') i++;
                count++;
            } else if (nextLine.charAt(i) == 'z') {
                if (sbString.charAt(i + 1) == '=') i++;
                count++;
            }else {
                count++;
            }
        }

        System.out.println(count);
    }
}

/*
    č	c=
    ć	c-
    dž	dz=
    đ	d-
    lj	lj
    nj	nj
    š	s=
    ž	z=
 */