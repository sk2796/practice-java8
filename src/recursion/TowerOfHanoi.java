package recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        printTowerOfHanoi(2, "a", "b", "c");
    }

    private static void printTowerOfHanoi(int n, String source, String auxillary, String destination) {
        if(n >0 ) {
            printTowerOfHanoi(n-1, source, destination, auxillary);
            System.out.println(source +" "+ destination);
            printTowerOfHanoi(n-1, auxillary, source, destination);
        }

    }
}
