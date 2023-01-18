import java.util.Scanner;

public class Willkommen {
    public static int tickets = 0;

    public static double price =  0.0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        begreussung();
        double zuZahlenderBetrag = fahrkartenbestellungErfassen(input);
        double eingezahlterGesamtBetrag = fahrkartenBezahlen(input, zuZahlenderBetrag);

        System.out.printf("Du hast %.2f EUR bezahlt.\n", eingezahlterGesamtBetrag);

        fahrkartenAusgeben();
    }

    public static void begreussung() {
        System.out.println("Hallo!");
    }

    public static double fahrkartenbestellungErfassen(Scanner input) {
        System.out.print("Ticket Preis: ");
        price = input.nextDouble();

        System.out.print("Ticket Anzahl: ");
        tickets = input.nextInt();

        return price * tickets;
    }

    public static double fahrkartenBezahlen(Scanner input, double amount) {
        System.out.printf("Zu zahlender Betrag: %.2f EUR\n", amount);

        double eingezahlterGesamtbetrag = 0.0;
        double nochZuZahlen = 0.0;
        while (eingezahlterGesamtbetrag < (price * tickets)) {
            nochZuZahlen = (price * tickets) - eingezahlterGesamtbetrag;

            System.out.println("Noch zu zahlen: " + String.format("%.2f", nochZuZahlen));
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");

            eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + input.nextDouble();
        }

        return eingezahlterGesamtbetrag;
    }

    public static void fahrkartenAusgeben() {
        System.out.println("Fahrschein wird ausgegeben");
        System.out.print("==========================");
    }
}
