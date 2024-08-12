package recursion;

import java.util.Arrays;
//Defect
public class Subsets {
    public static void main(String[] args) {
        int[] arr = new int[]{15,20,12};
        int[][] result = subsets(arr);
//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(a));
    }

    private static int[][] subsets(int[] input) {
        int[][] result = new int[][]{};
        int[] output = new int[]{};
        int[] smallAns = subset11(input, output);
        int[] smallAns1 = subset12(input, output);
        int i=0, j=0;
//        while()
        System.out.println(Arrays.toString(smallAns));
        System.out.println(Arrays.toString(smallAns1));

        return result;
    }

    private static int[] subset12(int[] input, int[] output) {
        if(input.length==0) {
            return output;
        }
        int[] smallInput = new int[input.length-1];
        System.arraycopy(input, 1, smallInput, 0, smallInput.length);
        int[] smallAns = subset11(smallInput, output);
        int[] result = new int[output.length+1];
        result[0] = input[0];
        System.arraycopy(smallAns, 0, result, 1, output.length);
        return result;
    }

    private static int[] subset11(int[] input, int[] output) {
        if(input.length==0) {
            return output;
        }
        int[] smallInput = new int[input.length-1];
        System.arraycopy(input, 1, smallInput, 0, smallInput.length);
        int[] smallAns = subset11(smallInput, output);
        return smallAns;

//        return output;
    }


//
//    private static int[] subsets(int[] arr, int[][] output) {
//        if(arr.length==0) {
//            return new int[]{};
//        }
//        int[] smallInput = new int[arr.length-1];
//        System.arraycopy(arr, 1, smallInput, 0, smallInput.length);
//        int[] smallAns = subsets(smallInput, output);
//        int[][] result;
//        if(smallAns.length<0) {
//            result = new int[2][smallInput.length+1];
//        } else {
//            result = new int[smallAns.length*2][smallInput.length+1];
//        }
////        System.arraycopy(smallAns, 0, result, 0, smallAns.length);
//        for (int i = 0; i < smallAns.length; i++) {
//            System.arraycopy(smallAns[i], 0, result[i], 0, smallAns[i].length);
//        }
////        System.out.println(Arrays.toString(result));
//        return result;
//    }
}
