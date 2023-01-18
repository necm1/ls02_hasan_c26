import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        double rueckgabebetrag;
        double nochZuZahlen;
        int tickets;

        // Geldbetrag eingeben
        System.out.print("Ticketpreis (Euro): ");
        zuZahlenderBetrag = tastatur.nextDouble();

        System.out.print("Anzahl der Tickets: ");
        tickets = checkTicketAmount(tastatur.nextInt(), tastatur);

        // Geldeinwurf
        eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;
        while (eingezahlterGesamtbetrag < (zuZahlenderBetrag * tickets)) {
            nochZuZahlen = (zuZahlenderBetrag * tickets) - eingezahlterGesamtbetrag;
            System.out.println("Noch zu zahlen: " + String.format("%.2f", nochZuZahlen));
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
        }

        // Fahrscheinausgabe
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

        // Rückgeldberechnung und -ausgabe
        rueckgabebetrag = eingezahlterGesamtbetrag - (zuZahlenderBetrag * tickets);

        if (rueckgabebetrag > 0.0) {
            System.out.println("Der Rückgabebetrag in Höhe von " + String.format("%.2f", rueckgabebetrag) + " Euro");
            System.out.println("wird in folgenden Münzen ausgezahlt:");

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
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }

    public static int checkTicketAmount(int amount, Scanner scanner) {
        if (amount > 0 && amount < 10) {
            return amount;
        }

        System.out.println(" >> Wählen Sie bitte eine Anzahl von 10 bis 10 Tickets aus. << ");
        System.out.print("Anzahl der Tickets: ");
        return checkTicketAmount(scanner.nextInt(), scanner);
    }
}