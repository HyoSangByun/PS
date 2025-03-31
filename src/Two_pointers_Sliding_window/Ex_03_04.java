package Two_pointers_Sliding_window;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_03_04 { //연속 부분수열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int count = 0;

        for (int px = 0; px < n - 1; px++) {
            int sum = list.get(px);

            for (int py = px+1; py < n; py++) {
                sum += list.get(py);
                if (sum == m) {
                    count++;
                    break;
                }
                else if (sum > m) break;
            }
        }

        System.out.println(count);
    }
}
/*
px=0, py=1로 설정 후에
py를 배열 끝까지 증가(py는 m보다 작을때까지 py++)시키면서 sum을 더해서 sum이 m보다 크면 px++, py=px+1, break

만약 sum이 m과 같다면 px++, py=px+1
 */


/*
내가 푼 방식은 O(n^2) 시간복잡도이다
sliding window로 해야 O(n)
 */