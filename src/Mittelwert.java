public class Mittelwert {
    public static void main(String[] args) {
        double x = 2.0;
        double y = 4.0;

        System.out.printf("Der Mittelwert von %.2f und %.2f ist %.2f\n", x, y, berechneMittelwert(x, y));
    }

    public static double berechneMittelwert(double x, double y) {
        return (x + y) / 2.0;
    }
}