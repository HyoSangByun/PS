package Swea;

import java.util.Base64;
import java.util.Scanner;

public class Ex_1928 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            String nextLine = sc.nextLine();

            byte[] decode = Base64.getDecoder().decode(nextLine);
            String answer = new String(decode);

            System.out.println("#" + i + " " + answer);
        }
    }

}

/*
 문제 요약
1. 표1을 보고 입력받은 문자들을 각각 대응하는 숫자로 변경한다.
2. 각 숫자들을 6자리 이진수로 표현하고, 이 이진수들을 한 줄로 쭉 이어 붙인다.
3. 한 줄로 쭉 이어붙인 이진수들을 8자리씩 끊어서 십진수로 바꾼다.
4. 각각의 십진수를 아스키 코드로 변환한다.


1. 24bit 버퍼에 MSB부터 한 byte씩 총 3byte를 집어넣는다.
1byte = 8bit
아스키코드에서 문자 하나는 1byte임 즉 버퍼 안에 세글자를 집어넣는다는 뜻이다.
세글자의 십진수 비트값을 각각 a, b, c라고 해보고 버퍼를 쭉 읽어서 십진수로 나타내면 아래와 같다.
a * 256^2 + b * 256^1 + c x 256^0

2. 버퍼의 MSB부터 6bit씩 잘라 그 값을 읽고, 각각의 값을 표처럼 인코딩한다.
24bit 짜리를 6bit씩 자르면 해당값은 000000(0)부터 111111(63)까지의 값이다.
즉, 버퍼안의 숫자를 아래와 같은 표기법으로 바꾼 뒤, 총 4개의 계수로 바꾸는 것이다.
A * 64^3 + B * 64^2 + C * 64^1 + D * 64^0


 */