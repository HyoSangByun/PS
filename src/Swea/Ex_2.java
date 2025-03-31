package Swea;

public class Ex_2 {

    public static void main(String[] args) {
        String s = "adf";

        if (s.isEmpty()) {
            System.out.println("empty");
        } else {
            if (!s.matches("-?\\d+")) {
                throw new IllegalArgumentException("계산식의 형태가 올바르지 않습니다.");
            }

            try {
                int parsedNumber = Integer.parseInt(s);
                System.out.println(parsedNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자의 범위가 범위 밖입니다.");
            }

        }
    }
}
