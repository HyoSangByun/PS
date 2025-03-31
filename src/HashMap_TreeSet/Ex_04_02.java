package HashMap_TreeSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Ex_04_02 { //아나그램(해쉬)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray1 = sc.next().toCharArray();
        char[] charArray2 = sc.next().toCharArray();

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        
        for (int i = 0; i < charArray1.length; i++) {
            Integer count = hashMap1.get(charArray1[i]);
            if (count == null) hashMap1.put(charArray1[i], 1); 
            else hashMap1.put(charArray1[i], count+1);
        }

        for (int i = 0; i < charArray2.length; i++) {
            Integer count = hashMap2.get(charArray2[i]);
            if (count == null) hashMap2.put(charArray2[i], 1);
            else hashMap2.put(charArray2[i], count+1);
        }

        String answer = "YES";
        for (Character c : hashMap1.keySet()) {
            if (hashMap1.get(c) != hashMap2.get(c)) {
                answer = "NO";
            }
        }

        System.out.println(answer);
    }
}

/*
HashMap에서 첫번째 문자는 삽입해주고
두번째문장에서는 감소해줘서 모두 value값이 0이면 Yes
그런데 만약 key값이 다른게 있다? containsKey()로 바로 NO
key 개수가 다르다? value값이 감소시키는 중에 0이되면 바로 NO <-- 길이가 같은 트린 아나그램이면 반드시 문자 하나는 더 많고 다른 문자하나는 적음
 */
