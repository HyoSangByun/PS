package HashSet;

import java.util.HashSet;
import java.util.Scanner;

public class Ex_1920 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (set.contains(sc.nextInt())) {
                sb.append(1).append('\n');
            } else sb.append(0).append('\n');
        }

        System.out.print(sb);
    }

}
