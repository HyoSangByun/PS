import java.util.HashMap;
import java.util.Scanner;

public class Ex_10816 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            hashMap.put(k, hashMap.getOrDefault(k, 0) + 1);
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int k = sc.nextInt();
            sb.append(hashMap.getOrDefault(k, 0)).append(' ');
        }

        System.out.println(sb);
    }

}
