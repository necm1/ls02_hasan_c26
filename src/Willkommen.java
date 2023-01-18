import java.util.Scanner;

public class Willkommen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        begreussung();
        double zuZahlenderBetrag = fahrkartenbestellungErfassen(input);

        System.out.printf("Zu zahlender Betrag: %.2f EUR", zuZahlenderBetrag);
    }

    public static void begreussung() {
        System.out.println("Hallo!");
    }

    public static double fahrkartenbestellungErfassen(Scanner input) {
        System.out.print("Ticket Preis: ");
        double price = input.nextDouble();

        System.out.print("Ticket Anzahl: ");
        double amount = input.nextDouble();

        return price * amount;
    }
}
