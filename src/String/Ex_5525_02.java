package String;

import java.util.Scanner;

public class Ex_5525_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int length = sc.nextInt();
        char[] charArray = sc.next().toCharArray();

        int answer = 0;
        int count = 0;
        for (int i = 1; i < length - 1; i++) {
            if (charArray[i - 1] == 'I' && charArray[i] == 'O' && charArray[i + 1] == 'I') {
                count++;

                if (count == N) {
                    count--;
                    answer++;
                }
                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(answer);
    }
}

/*
    이 코드의 시간복잡도는 O(M)이지만, 서브스트링을 사용하면 O(N*M) 시간복잡도가 된다.
 */