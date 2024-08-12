package recursion;
// Defect
public class Subset {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
//        int[][] result = subset(arr);
        int[][] a = new int[2][1];
        System.out.println(a.length);
        System.out.println(a[0].length);
    }

    private static int[][] subset(int[] arr) {
        if(arr.length == 0) {
            return new int[][]{};
        }
        int[] smallInput = new int[arr.length-1];
        System.arraycopy(arr, 1, smallInput, 0, smallInput.length);
        int[][] smallAns = subset(smallInput);
        int[][] smallRes;
        if(smallAns.length==0) {
            smallRes = new int[2][smallInput.length];
        }
        else smallRes = new int[2 * smallAns.length][smallInput.length];
//        for()

        return smallAns;
    }
}
