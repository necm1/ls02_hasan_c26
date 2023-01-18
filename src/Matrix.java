import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Geben Sie eine Ziffer zwischen 2 und 9 ein: ");
        int ziffer = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int result = i * j;
                if (result % ziffer == 0 || result % 10 == ziffer || result / 10 == ziffer) {
                    System.out.printf("%4s", "*");
                } else {
                    System.out.printf("%4d", result);
                }
            }
            System.out.println();
        }
    }
}