package HashMap_TreeSet;

import java.util.Scanner;
import java.util.TreeMap;

public class Ex_7662 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>(); // TreeMap으로 빈도 관리

            for (int j = 0; j < N; j++) {
                String command = sc.next();
                int num = sc.nextInt();

                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1); // 삽입
                } else if (!map.isEmpty()) {
                    if (num == 1) { // 최댓값 삭제
                        int maxKey = map.lastKey();
                        if (map.put(maxKey, map.get(maxKey) - 1) == 1) {
                            map.remove(maxKey); // 빈도가 0이면 삭제
                        }
                    } else { // 최솟값 삭제
                        int minKey = map.firstKey();
                        if (map.put(minKey, map.get(minKey) - 1) == 1) {
                            map.remove(minKey); // 빈도가 0이면 삭제
                        }
                    }
                }
            }

            // 결과 출력
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }

}
