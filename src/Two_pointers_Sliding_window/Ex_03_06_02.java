package Two_pointers_Sliding_window;

import java.util.Scanner;

public class Ex_03_06_02 { //연속 부분수열 !time limit exceed
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
        int sum = 0;
        int lastZeroIndex = 0;
        int lastIndex = 0;

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            sum += Character.getNumericValue(charArray[i]);
            if (charArray[i] == '0') {
                count++;
                if(count == k) lastZeroIndex = i;
                else if (count == k+1) {
                    lastIndex = i - 1 ;
                    break;
                }
            }
        }

        for (int i = lastZeroIndex+1; i < n; i++) {

        }




    }
}

//  14 2
//  1 1 0 0 1 1 0 1 1 0 1 1 0 1

/*
two pointer 알고리즘
lt, rt를 증가하면서 lt~rt에서 0이 k번보다 크게 나타나지 않도록 관리해주면서 최대길이를 구함
rt가 끝에 올때까지
 */