package recursion;

//DEFECT
public class SubsetSumKFinal {
    public static void main(String[] args) {
        int target = 13;
        int[] arr = new int[]{20,19,12,2,10,6,17,2,14,9,3,1,4,12,7,18,9,20,13,7};
        int[][] res = subset(arr, target);
    }

    private static int[][] subset(int[] input, int target) {
        int[][] result = new int[][]{};
        int[] smallAns = new int[]{};
        for (int i = 0; i < input.length; i++) {
            if(target == input[i]) {
                result = get2DArray(result, new int[]{input[i]});
            }
            else if(target > input[i]) {
//                int comp = target - input[i];
                smallAns = arrayOfCombination(input, target, i);
            }
        }
        return result;
    }

    private static int[] arrayOfCombination(int[] input, int target, int startIndex) {
        int[] ans = new int[]{};
        if(startIndex == input.length-1) {

        }
        return null;
    }

    private static int[][] get2DArray(int[][] result, int[] x) {
        int[][] res = new int[result.length+1][x.length];
        System.arraycopy(result, 0, res, 0, result.length);
        res[result.length] = x;
        return res;
    }
}
