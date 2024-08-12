package recursion;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 5, 3, 0, 6, 1, 4};
        sortArray(arr);
    }

    private static int[] sortArray(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int temp = arr[arr.length-1];
        int[] smallArr = new int[arr.length-1];
        System.arraycopy(arr, 0, smallArr, 0, smallArr.length);
        System.out.println(Arrays.toString(arr));
        int[] smallAns = sortArray(smallArr);
        smallAns = insertres(smallAns, temp);
        System.out.println("SmallAns");
        System.out.println(Arrays.toString(smallAns));
        return smallAns;
    }

    private static int[] insertres(int[] smallAns, int temp) {
        int[] res = new int[smallAns.length+1];
        int k = 0;
        int i = 0;
        boolean tempFilled = false;
        while(i < smallAns.length) {
            if(!tempFilled) {
                if(smallAns[i] > temp) {
                    res[k] = temp;
                    tempFilled = true;
                    k++;
                }else {
                    res[k] = smallAns[i];
                    i++; k++;
                }
            } else {
                res[k] = smallAns[i];
                i++; k++;
            }
        }
        return res;
    }
}
