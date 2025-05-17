import java.util.Scanner;

public class Ex_1182 {

    static int N, S, answer;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 크기가 1부터 N까지인 부분 수열 구하기
        for (int i = 1; i <= N; i++) {
            int[] array = new int[i];
            DFS(0, 0, i, array);
        }

        System.out.println(answer);
    }

    static void DFS(int count, int start, int length, int[] array) {
        if (count == length) {
            int sum = 0;
            for (int i : array) {
                sum += i;
            }
            if (sum == S) {
                answer++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            array[count] = arr[i];
            DFS(count + 1, i + 1, length, array);
        }
    }

}
