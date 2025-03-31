package HashMap_TreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_9357 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            Map<String, Integer> map = new HashMap<>();
            int M = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < M; j++) {
                String item = sc.next();
                String itemType = sc.next();

                map.put(itemType, map.getOrDefault(itemType, 0) + 1);
            }

            int answer = 1;
            for (Integer value : map.values()) {
                answer *= (value + 1);
            }

            System.out.println(answer - 1);
        }
    }
}
