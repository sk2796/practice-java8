package recursion;

import java.util.Arrays;

public class MergeSortWithRecursion {
    public static void main(String[] args) {
        int[] a = new int[] {97,3,81,45,32,65,21,2,43};
        mergeSortRecursion(a, 0, a.length-1);
    }

    private static void mergeSortRecursion(int[] arr, int start, int end) {
        if(start>=end) {
            return;
        }

        int mid = (start + end)/2;
        mergeSortRecursion(arr, start, mid);
        mergeSortRecursion(arr, mid+1, end);
        mergeSortFinal(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortFinal(int[] arr, int start, int end) {
        int mid = (start+end)/2;
        int i = start, j = mid+1, k =0;
        int[] res = new int[end-start+1];
        while(i <= mid && j<=end) {
            if(arr[i]> arr[j]) {
                res[k] = arr[j];
                k++; j++;
            } else {
                res[k] = arr[i];
                k++; i++;
            }
        }
        while(i <= mid) {
            res[k] = arr[i];
            k++; i++;
        }
        while(j <=end) {
            res[k] = arr[j];
            k++; j++;
        }
        System.arraycopy(res, 0, arr, start, res.length);
    }
}
