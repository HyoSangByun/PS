package HashMap_TreeSet;

import java.util.*;

public class Ex_04_01 { //학급 회장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();

        char[] charArray = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer count = map.get(charArray[i]);
            if (count == null) map.put(charArray[i], 1);
            else map.put(charArray[i], count + 1);
        }

        int max = 0;
        char student = 'a';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                student = entry.getKey();
            }
        }

        System.out.println(student);
    }
}
