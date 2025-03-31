import java.math.BigInteger;
import java.util.Scanner;

public class Ex_1629 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();
        int i3 = sc.nextInt();

        double v = Math.pow(i1, i2) % i3;
        System.out.println((int) v);
    }

}
