package greedy.baekjoon;

import java.util.*;

public class Ex_14_2 { //백준 1700
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[K];
        boolean[] ch = new boolean[K + 1];

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> consent = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < K; i++) {
            if (consent.size() < N) consent.add(arr[i]);
            else {
                if (!consent.contains(arr[i])) {
                    int latestUsage = -1;
                    int toUnplug = -1;

                    for (Integer existed : consent) {
                        int nextUsage = Integer.MAX_VALUE;
                        for (int j = i + 1; j < K; j++) {
                            if (arr[j] == existed) {
                                nextUsage = j;
                                break;
                            }
                        }

                        // 가장 나중에 사용되는 기기를 찾음 ( 가장 큰 값 )
                        if (nextUsage > latestUsage) {
                            latestUsage = nextUsage;
                            toUnplug = existed;
                        }
                    }

                    consent.remove(toUnplug);
                    consent.add(arr[i]);
                    answer++;
                }
            }
            
        }

        System.out.println(answer);
    }
}

/*
    꽉차있고 꽂혀있는게 들어옴 -> 아무것도 안함
    꽉차있고 안 꽂혀있는게 들어옴 -> 우선순위 낮은 걸 버림

    위 방식이 아닌
    현재 시점에서 가장 나중에 사용할 기기를 빼는게 맞음
 */