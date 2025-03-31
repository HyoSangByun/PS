package String;

import java.util.Arrays;
import java.util.Scanner;

public class ex_01_10 { //문자거리 !못품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char c = sc.next().charAt(0);
        String inputReverse = new StringBuilder(input).reverse().toString();

        Integer[] array1 = new Integer[input.length()];
        Integer[] array2 = new Integer[input.length()];

        //오른쪽방향으로 순회
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == c) {
                array1[i] = 0;
            } else { //일치하지 않는다면
                array1[i] = input.indexOf(c, i) - i;
            }
        }
        System.out.println(Arrays.toString(array1));

        //왼쪽방향으로 순회
        for (int i = 0; i < inputReverse.length(); i++) {
            if (inputReverse.charAt(i) == c) {
                array2[i] = 0;
            } else { //일치하지 않는다면
                array2[i] = inputReverse.lastIndexOf(c, i);
            }
        }
        System.out.println(Arrays.toString(array2));

        //최솟값 넣기
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] >array2[i]) {
                array1[i] = array2[i];
            }
        }

        for (Integer i : array1) {
            System.out.print(i + " ");
        }

    }

}

/*
왼쪽 한번 오른쪽 한번으로 target값이면 0 아니면 1증가시켜서 값을 넣어준다
주의할것은 처음 넣는 값은 매우 큰 값으로
 */