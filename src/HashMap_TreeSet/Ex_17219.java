package HashMap_TreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_17219 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String site = sc.next();
            String pw = sc.next();
            map.put(site, pw);
        }

        for (int i = 0; i < M; i++) {
            String next = sc.next();
            sb.append(map.get(next));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
