package Two_pointers_Sliding_window;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_03_06 { //연속 부분수열 !time limit exceed
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        String str = "";
        for (int i = 0; i < n; i++) {
            str += sc.next();
        }
        int max = 0;
        int count=0;

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {

            for (int j = i; j < charArray.length; j++) {
                if (charArray[j] == '0') {
                    count++;
                    if (count == k+1) {
                        int length = j - i ;
                        if (length > max) max = length;
                        count = 0;
                        break;
                    }
                }
            }

        }

        System.out.println(max);



    }
}

//  14 2
//  1 1 0 0 1 1 0 1 1 0 1 1 0 1

/*
    110011
    10011
    0011
    0110
    11011011
    1011011
    011011
    1101101
    ...
    101101
    01101

    px는 0으로 초기화
    0이 k+1번나올때까지 문자를 잘라줌

 */