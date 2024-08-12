package recursion;

public class PrintNaturalNumbers {
    public static void main(String[] args) {
        int n = 10;
        printNaturalAsc(n);
//        printNaturalDesc(n);
    }

    private static void printNaturalAsc(int n) {
        if(n==1) {
            System.out.println(n);
            return;
        }
        printNaturalAsc(n-1);
        System.out.println(n);
    }

    private static void printNaturalDesc(int n) {
        if(n==1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNaturalDesc(n-1);
    }
}
