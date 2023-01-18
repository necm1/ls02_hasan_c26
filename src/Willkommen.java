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

        rueckgeldAusgeben(zuZahlenderBetrag, eingezahlterGesamtBetrag);
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
        System.out.println("==========================");
    }

    public static void rueckgeldAusgeben(double zuZahlenderBetrag, double eingezahlterGesamtbetrag) {
        // Rückgeldberechnung und -ausgabe
        double rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;

        if (rueckgabebetrag > 0.0) {
            System.out.println("Der Rückgabebetrag in Höhe von " + String.format("%.2f", rueckgabebetrag) + " Euro");
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            rueckgabebetrag = muenzRueckgabe(rueckgabebetrag);
        }
    }

    public static double muenzRueckgabe(double rueckgabebetrag) {
        while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
            System.out.println("2 Euro");
            rueckgabebetrag = rueckgabebetrag - 2.0;
        }
        while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
            System.out.println("1 Euro");
            rueckgabebetrag = rueckgabebetrag - 1.0;
        }
        while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
            System.out.println("50 Cent");
            rueckgabebetrag = rueckgabebetrag - 0.5;
        }
        while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
            System.out.println("20 Cent");
            rueckgabebetrag = rueckgabebetrag - 0.2;
        }
        while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
            System.out.println("10 Cent");
            rueckgabebetrag = rueckgabebetrag - 0.1;
        }

        /**
         * Ticketpreis (Euro): 2,10
         * Anzahl der Tickets: 1
         *
         * Letzter Ticket ist 0,049 => aufrunden, damit wir den Rest ausgeben können
         */
        while ((Math.round(rueckgabebetrag*100.0)/100.0) >= 0.05) { // 5-Cent-Münzen
            System.out.println("5 Cent");
            rueckgabebetrag = rueckgabebetrag - 0.05;
        }

        return rueckgabebetrag;
    }
}
