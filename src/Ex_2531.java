import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Ex_2531 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //접시 개수
        int d = sc.nextInt(); //초밥의 가짓수
        int k = sc.nextInt(); //연속해서 먹는 접시 개수
        int c = sc.nextInt(); //쿠폰 번호

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // 번호 - 개수
        hashMap.put(c, 1);
        for (int i = 0; i < k; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        int answer = hashMap.size();
        int lt = 0;
        int rt = k ;

        for (int i = lt; i < N; i++) {
            hashMap.put(arr[i], hashMap.get(arr[i]) - 1);
            if (hashMap.get(arr[i]) == 0) hashMap.remove(arr[i]);

            hashMap.put(arr[rt], hashMap.getOrDefault(arr[rt], 0) + 1);
            rt = (rt + 1) % N;
            answer = Math.max(hashMap.size(), answer);
        }

        System.out.println(answer);
    }

}
