package recursion;

import java.util.Map;

import static recursion.PhoneKeypad.keypadStrokes;

public class PrintKeypadNumbers {
    public static void main(String[] args) {
        printKeypadNumbers(234, "");
    }

    private static void printKeypadNumbers(int n, String output) {

        if(n==0 || n == 1) {
            System.out.print(output + " ");
            return;
        }
        Map<Integer, String> hmap = keypadStrokes();
        int rem = n%10;
        String[] strokes = hmap.get(rem).split("");

        for(String str : strokes) {
            printKeypadNumbers(n/10, str + output);
        }
    }
}
