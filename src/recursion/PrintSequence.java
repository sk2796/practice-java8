package recursion;

public class PrintSequence {
    public static void main(String[] args) {
        printSubSequence("xyz");
    }

    public static void printSubSequence(String str) {
        printSubSequence(str, "");
    }

    public static void printSubSequence(String str, String output) {
        if(str.isEmpty()) {
            System.out.println(output);
            return;
        }

        printSubSequence(str.substring(1), output);

        printSubSequence(str.substring(1), str.charAt(0) + output);
    }
}
