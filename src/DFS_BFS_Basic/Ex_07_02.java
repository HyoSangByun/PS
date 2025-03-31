package DFS_BFS_Basic;

import java.util.Scanner;

//10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용해서 출력해야함
public class Ex_07_02 { //재귀함수를 이용한 이진수 출력
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recursion(n);
    }

    public static void recursion(int n) {
        if (n == 0) return;
        else {
            recursion(n/2);
            System.out.print(n % 2);

        }

    }
}

/*
    DFS 깊이 우선 탐색

    재귀함수는 stack 프레임을 사용한다
    스택에는 매개변수, 지역변수, 복귀 주소를 저장한다
 */