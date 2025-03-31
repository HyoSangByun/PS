package DFS_BFS_Basic;

import java.util.ArrayList;
import java.util.Scanner;

//자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요
public class Ex_07_01 { //재귀함수(스택프레임)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recursion(n);
    }

    public static void recursion(int n) {
        if (n == 0) return;

        recursion(n - 1);
        System.out.print(n + " ");
        /*
            System.out.print(n + " ");
            recursion(n - 1);
            결과가 다름
         */
    }
}

/*
    DFS 깊이 우선 탐색

    재귀함수는 stack 프레임을 사용한다
    스택에는 매개변수, 지역변수, 복귀 주소를 저장한다
 */