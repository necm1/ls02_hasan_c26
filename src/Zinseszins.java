import java.util.Scanner;

public class Zinseszins {
    public static void main(String[] args) {
        double anlagesumme;
        double zinssatz;
        int anlagedauer;

        Scanner sc = new Scanner(System.in);

        System.out.print("Bitte geben Sie die Laufzeit für den Vertrag an: ");
        anlagedauer = sc.nextInt();

        System.out.print("Bitte geben Sie an wie viel Kapital Sie anlegen: ");
        anlagesumme = sc.nextDouble();

        System.out.print("Bitte geben Sie den Zinssatz an: \n");
        zinssatz = sc.nextDouble();

        System.out.printf("Eingezahltes Kapital: %.2f", anlagesumme);

        for (int i = 1; i <= anlagedauer; i++) {
            anlagesumme = anlagesumme + (anlagesumme * (zinssatz / 100));
        }

        System.out.printf("Ausgezahltes Kapital: %.2f", anlagesumme);
    }
}
