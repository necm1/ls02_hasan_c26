public class EinMalEins {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int result = i * j;
                System.out.printf("%4d", result);
            }
            System.out.println();
        }
    }
}
