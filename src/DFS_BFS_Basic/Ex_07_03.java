package DFS_BFS_Basic;

import java.util.Scanner;

//자연수 N이 입력된면 N!을 구하는 프로그램을 작성
public class Ex_07_03 { //팩토리얼
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(recursion(n));
    }

    public static int recursion(int n) {
        if (n == 1) return 1;
        else return n * recursion(n - 1);

    }
}

/*
    DFS 깊이 우선 탐색

    재귀함수는 stack 프레임을 사용한다
    스택에는 매개변수, 지역변수, 복귀 주소를 저장한다
 */