package Two_pointers_Sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_30804 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] tang = new int[N];
        for (int i = 0; i < N; i++) {
            tang[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;

        // 과일을 하나씩 모두 순회
        for (int right = 0; right < N; right++) {
            // map에 과일 종류 카운트
            // 과일 종류가 있으면 +1, 없으면 추가
            map.put(tang[right], map.getOrDefault(tang[right], 0) + 1);

            // 과일 종류가 3 종류일 때, 2 종류가 될 때까지 map에서 제거
            while (map.size() > 2) {
                // 앞에서부터 순차적으로 과일을 제거
                map.put(tang[left], map.get(tang[left]) - 1);
                if (map.get(tang[left]) == 0) {
                    map.remove(tang[left]);
                }
                left++;
            }
            // 최댓값 갱신
            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }

}
