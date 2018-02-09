package algorithm;

public class ChickenShopping {

    public static void main(String[] args) {
        for (int a = 0; a <= 34; a++) {
            for (int b = 0; b <= 50; b++) {
                for (int c = 0; c <= 80; c = c + 3) {

                    int value = 3 * a + 2 * b + c * 1 / 3;
                    int count = a + b + c;

                    if (count == 100 && value == 100) {
                        System.out.println(a + " " + b + " " + c);
                    }
                }
            }
        }

        String str = "operate_time";
        System.out.println(str);

    }
}
