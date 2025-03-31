package Implement;

import java.util.*;

public class Ex_2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>(); //빈도 수 체크용
        int[] arr = new int[N]; //중앙값 확인용
        //범위 확인용
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //산술평균 용
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            arr[i] = nextInt;
            min = Math.min(min, nextInt);
            max = Math.max(max, nextInt);
            sum += nextInt;

            map.put(nextInt, map.getOrDefault(nextInt, 0) + 1);
        }


        System.out.println(Math.round(sum / (double) N));

        Arrays.sort(arr);
//        System.out.println((int) Math.floor(N / 2.0));
        System.out.println(arr[(int) Math.floor(N / 2.0)]);

        int bindo = 0;
        int commonValue = 0;
        int check = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > bindo) {
                bindo = entry.getValue();
                commonValue = entry.getKey();
                check = 0;
            } else if (entry.getValue() == bindo) {
                check++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (check > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (map.get(arr[i]) == bindo) {
                    if (!list.contains(arr[i])) list.add(arr[i]);
                }
            }
            Collections.sort(list);
            System.out.println(list.get(1));
        }
        else System.out.println(commonValue);


        System.out.println(max - min);
    }
}
