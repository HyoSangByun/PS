package HashSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex_1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<String> answers = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        for (int i = 0; i < M; i++) {
            String next = sc.next();
            if (set.contains(next)) {
                answers.add(next);
            }
        }

        Collections.sort(answers);
        System.out.println(answers.size());
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

}
