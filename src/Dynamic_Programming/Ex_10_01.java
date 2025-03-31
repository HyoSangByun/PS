package Dynamic_Programming;

import java.util.Scanner;

public class Ex_10_01 {
    public static void main(String[] args) { //계단오르기 (피보나치 수열 )
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dy = new int[N + 1];
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= N; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        System.out.println(dy[N]);
    }
}
/*
    Dynamic Programming
    복잡한 문제를 작은 하위 문제들로 나누어 그 결과를 저장하고, 저장된 값을 재사용하여 문제를 해결하는 알고리즘 기법입니다. 주로 최적화 문제
    직관적으로 알 수 있는 방식부터 확장함
    그 답을 메모이제이션함

    동적 계획법의 두 가지 접근 방식
    1. Top-Down (메모이제이션):
    재귀를 이용해 문제를 상위에서 하위로 분할하여 해결합니다.
    해결된 하위 문제의 결과를 메모리에 저장해두고, 동일한 문제가 다시 등장하면 저장된 값을 재사용합니다.
    재귀 호출을 사용하지만, 각 하위 문제는 한 번만 계산됩니다.

    2. Bottom-Up (타뷸레이션):
    작은 하위 문제부터 해결하여 점진적으로 상위 문제를 해결해 나갑니다.
    반복문을 이용해 문제를 해결하며, 결과를 배열 등에 저장하고 차례대로 값을 채워나갑니다.
    재귀를 사용하지 않으므로, 호출 스택의 오버헤드가 없고 메모리를 절약할 수 있습니다.
 */