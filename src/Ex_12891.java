import java.util.Arrays;
import java.util.Scanner;

public class Ex_12891 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();
        String DNA = sc.next();
        int[] condition = new int[4];
        for (int i = 0; i < 4; i++) {
            condition[i] = sc.nextInt();
        }
        int lp = 0;
        int rp = P;
        int[] ch = new int[4];
        //초기 상태
        for (int i = 0; i < P; i++) {
            if (DNA.charAt(i) == 'A') {
                ch[0]++;
            } else if (DNA.charAt(i) == 'C') {
                ch[1]++;
            } else if (DNA.charAt(i) == 'G') {
                ch[2]++;
            } else if (DNA.charAt(i) == 'T') {
                ch[3]++;
            }
        }
        int answer = (ch[0] >= condition[0] && ch[1] >= condition[1] && ch[2] >= condition[2] && ch[3] >= condition[3]) ? 1 : 0;

        for (int i = 0; i <= S - P - 1; i++) {
            if (DNA.charAt(i) == 'A') {
                ch[0]--;
            } else if (DNA.charAt(i) == 'C') {
                ch[1]--;
            } else if (DNA.charAt(i) == 'G') {
                ch[2]--;
            } else if (DNA.charAt(i) == 'T') {
                ch[3]--;
            }

            if (DNA.charAt(i + P) == 'A') {
                ch[0]++;
            } else if (DNA.charAt(i + P) == 'C') {
                ch[1]++;
            } else if (DNA.charAt(i + P) == 'G') {
                ch[2]++;
            } else if (DNA.charAt(i + P) == 'T') {
                ch[3]++;
            }

            if (ch[0] >= condition[0] && ch[1] >= condition[1] && ch[2] >= condition[2] && ch[3] >= condition[3]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
