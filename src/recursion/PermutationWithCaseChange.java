package recursion;

//DEFECT
public class PermutationWithCaseChange {
    public static void main(String[] args) {
        String input = "ab";
        fun(input, "");
//        int p = (int) input.charAt(0);
//        System.out.println((int) input.charAt(0));
//        System.out.println((char) (p+32));
    }

    private static void fun(String input, String output) {
        if(input.length()==0) {
            System.out.println(output);
            return;
        }

        String comp = compliment(input.charAt(0));
        fun(input.substring(1), comp + output);
        System.out.println(output);
        String comp2 = compliment(input.charAt(0));
//        fun(input.substring(1), );


    }

    private static String compliment(char c) {
        int x = c;
        if(x>=65 && x<=97) {
            return String.valueOf((char) (x+32));
        }
        else return String.valueOf((char) (x-32));
    }
}
