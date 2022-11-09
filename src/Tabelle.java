import java.util.Arrays;

/**
 * @see https://moodle.oszimt.de/mod/page/view.php?id=451189&forceview=1
 */
public class Tabelle {
    public static void main(String[] args) {
        Temperature[] temperatures = new Temperature[5];
        String[] delimeters = new String[32];

        // Assign temperatures
        temperatures[0] = new Temperature(-20, -28.8889);
        temperatures[1] = new Temperature(-10, -23.3333);
        temperatures[2] = new Temperature(+0, -17.7778);
        temperatures[3] = new Temperature(+20, -6.6667);
        temperatures[4] = new Temperature(+30, -1.1111);

        System.out.printf( "%-20s|", "Fahrenheit");
        System.out.printf("%10s\n", "Celcius");

        for(int i = 0; i < 32; i++) {
            delimeters[i] = "-";
        }

        System.out.print(String.join("", delimeters) + "\n");
        for (Temperature temperature : temperatures){
            System.out.printf( "%-20s|", temperature.getFahr());
            System.out.printf("%10.2f\n", temperature.getCelcius());
        }
    }
}

/**
 * @class Temperature
 */
class Temperature {
    private double celcius;
    private int fahr;

    /**
     * Temperature Constructor
     *
     * @constructor
     * @param fahr
     * @param celcius
     */
    public Temperature(int fahr, double celcius) {
        this.celcius = celcius;
        this.fahr = fahr;
    }

    /**
     * @public
     * @return {int}
     */
    public double getCelcius() {
        return celcius;
    }

    /**
     * @public
     * @return {double}
     */
    public int getFahr() {
        return fahr;
    }
}