package Implement;

public class Ex_4673 {

    static boolean[] check = new boolean[10000];

    public static void main(String[] args) {
        for (int j = 1; j < 10000; j++) {
            selfNumber(j);
        }

        for (int j = 1; j < 10000; j++) {
            if (!check[j]) {
                System.out.println(j);
            }
        }
    }

    private static void selfNumber(int n) {
        int sum = n; // 시작 숫자 n
        while (n > 0) {
            sum += n % 10; // n의 마지막 자리수 더하기
            n /= 10; // n을 10으로 나누어 마지막 자리수를 제거
        }
        if (sum < 10000) {
            check[sum] = true; // 셀프 넘버 여부 체크
        }
    }
}

/*
    우선 n이 몇자리의 숫자인 지 확인 부터 해야함
 */