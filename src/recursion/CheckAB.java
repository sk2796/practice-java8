package recursion;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class CheckAB {

    public static void main(String[] args) {
        String str = "aaaaabbaaaabb";
        System.out.println(checkAB(str, 0));
    }

    private static boolean checkAB(String str, int index) {
        if(index == str.length()-1 ) {
            if(str.charAt(index) == 'a') {
                return true;
            }
        }
        if(str.charAt(index) == 'a') {
            if(str.charAt(index+1) == 'b' && str.charAt(index+2) == 'b') {
                if(str.substring(index).length()>3) {
                    return checkAB(str, index+3);
                }
                else return true;
            }
            else return checkAB(str, index+1);
        }
        return false;
    }
}
