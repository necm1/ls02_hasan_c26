import java.util.Scanner;

public class Summe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Geben Sie bitte die Zahl ein: ");
        int n = input.nextInt();

        System.out.println("Die Zahlen werden addiert: ");

        int i = 1;
        int result = 0;

        while (i <= n) {
            System.out.println(i);
            result = result + i;
            i++;
        }

        System.out.println("Die Summe beträgt: " + result);
    }
}
