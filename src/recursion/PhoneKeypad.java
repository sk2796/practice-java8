package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneKeypad {
    public static void main(String[] args) {
        int n = 27;
        String[] result = keypad(n);
//        String[] result = new String[] {""};
        System.out.println(Arrays.toString(result));
        System.out.println(result.length);
    }

    private static String[] keypad(int n) {
        Map<Integer, String> hmap = keypadStrokes();
        if(n == 0 || n ==1 ) {
            return new String[]{""};
        }
        int rem = n%10;
        String[] strokes = hmap.get(rem).split("");
        String[] prevRes = keypad(n/10);
        String[] result = new String[prevRes.length * strokes.length];
        int k=0;
        for (String prevRe : prevRes) {
            for (String stroke : strokes) {
                result[k] = prevRe + stroke;
                k++;
            }
        }
        return result;
    }

    public static Map<Integer, String> keypadStrokes() {
        Map<Integer, String> hmap = new HashMap<>();
        hmap.put(2, "abc");
        hmap.put(3, "def");
        hmap.put(4, "ghi");
        hmap.put(5, "jkl");
        hmap.put(6, "mno");
        hmap.put(7, "pqrs");
        hmap.put(8, "tuv");
        hmap.put(9, "wxyz");
        return hmap;
    }
}
