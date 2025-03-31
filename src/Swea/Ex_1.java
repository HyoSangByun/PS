package Swea;

import java.util.ArrayList;
import java.util.List;

public class Ex_1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(",");
        list.add(";");
        String cal = "1;2,3@@";
        String regx = String.join("|", list);
        String[] parts = cal.split(regx, -1);

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
            System.out.println((i +1)+"번쨰 : " +parts[i]);
        }
    }

}
