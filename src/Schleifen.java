import java.util.Arrays;

public class Schleifen {
    public static void main(String[] args) {
        int[] breakpointNumbers = {10*2, 12*2, 13*2, 14*2};
        int[] continueNumbers = {15*2, 16*2, 17*2};

        int i = 1;
        while(i <= 20) {
            System.out.printf("%d ", i*i);
            i = i+1;

            if (Arrays.stream(breakpointNumbers).boxed().toList().contains(i)) break;

            if (Arrays.stream(continueNumbers).boxed().toList().contains(i)) continue;
        }
    }
}
