package HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Ex_1620 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            String next = sc.next();
            map1.put(next, i);
            map2.put(i, next);
        }

        for (int i = 0; i < M; i++) {
            String nextLine = sc.next();
            if (isNumeric(nextLine)) {
                int i1 = Integer.parseInt(nextLine);
                System.out.println(map2.get(i1));
            } else {
                System.out.println(map1.get(nextLine));
            }
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // 정수일 경우
            return true; // 변환이 성공하면 숫자 형식
        } catch (NumberFormatException e) {
            return false; // 변환 실패 시 숫자 형식 아님
        }
    }
}
