package HashMap_TreeSet;

import java.util.*;

public class Ex_04_04 { //모든 아나그램 찾기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray1 = sc.next().toCharArray();
        char[] charArray2 = sc.next().toCharArray();

        int count = 0;

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : charArray2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < charArray1.length - charArray2.length + 1; i++) { // 0~5
            HashMap<Character, Integer> map1 = new HashMap<>();
            boolean b = true;

            for (int j = i; j < i + charArray2.length; j++) { //5~8
                map1.put(charArray1[j], map1.getOrDefault(charArray1[j], 0) +1 );
            }

            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {

                if (map2.get(entry.getKey()) != entry.getValue()) {
                    b = false;
                }
            }

            if (b == true) count ++;
        }

        System.out.println(count);
    }
}

/*
해설은 슬라이딩 윈도우로 lt는 삭제 rt는 추가로 구현함
 */