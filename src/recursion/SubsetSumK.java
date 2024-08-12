package recursion;

//Partial done
public class SubsetSumK {
    public static void main(String[] args) {
        int[] input = new int[] {17,18,6,11,2,6};
        int target = 6;
        int res;
        int[][] final2DArray = new int[0][0];
        int k = 0;
//        for (int i = 0; i < input.length - 1; i++) {
//            int comp = target - input[i];
//            int[] result = new int[2];
//            res = subsetsSumK(input, comp, i+1);
//            if(res!=-1) {
////                System.out.println(input[i] + " " +res);
//                result[0] = input[i];
//                result[1] = res;
//                final2DArray[k] = result;
//                k++;
//             }
//        }
        int[][] result = new int[][]{};
        for (int i = 0; i < input.length; i++) {
            if(target == input[i]) {
                result = getFinal2DArray(result, new int[]{input[i]});
            }
            else if(target > input[i]) {
                int comp = target - input[i];
                if(i<input.length-1) {
                    int[] smallAns = subset(input, comp ,input[i],  i+1);
                    if(smallAns.length>0) {
                        result = getFinal2DArray(result, smallAns);
                    }
                }
            }
        }
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getFinal2DArray(int[][] final2DArray, int[] smallAns) {
        int[][] result = new int[final2DArray.length+1][2];
        System.arraycopy(final2DArray, 0, result, 0, final2DArray.length);
        result[final2DArray.length] = smallAns;
        return result;
    }

    private static int[] subset(int[] arr, int target, int entry, int startIndex) {
        int[] res = new int[2];
//        if(target == entry) {
//            return new int[]{entry};
//        }
        if(startIndex == arr.length-1) {
            if(arr[startIndex] == target) {
                res[0] = entry;
                res[1] = arr[startIndex];
                return res;
            }
            else return new int[]{};
        }
        if(arr[startIndex] == target) {
            res[0] = entry;
            res[1] = arr[startIndex];
            return res;
        }
        else return subset(arr, target, entry, startIndex+1);
    }
    private static int subsetsSumK(int[] input, int target, int startIndex) {
        if(input.length-1 == startIndex) {
            if(input[startIndex]== target) {
//                System.out.println("Found" + input[startIndex]);
                return input[startIndex];
            }
            else return -1;
        }

        if(input[startIndex] == target) {
            return input[startIndex];
        }
        else return subsetsSumK(input, target, startIndex+1);
    }
}
