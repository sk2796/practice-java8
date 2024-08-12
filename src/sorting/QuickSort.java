package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {526,112,581,450,533,346,94,454,302,847,31,76,695,703,400,208,889,355,484,966,330,851,847,845,606,614,825};
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start>=end) {
            return;
        }
        int pivotPos = pivotPos(arr, start, end);
        swapPivot(arr, start, pivotPos);
        sortOnPivot(arr, start, pivotPos, end);
        quickSort(arr, start, pivotPos-1);
        quickSort(arr, pivotPos+1, end);
        System.out.println(Arrays.toString(arr));
    }

    private static void swapPivot(int[] arr, int start, int pivotPos) {
        int temp = arr[pivotPos];
        arr[pivotPos] = arr[start];
        arr[start] = temp;
    }

    private static void sortOnPivot(int[] arr, int start, int pivotPos, int end) {
        int i= start, j = end;
        while(i<pivotPos && j>pivotPos) {
            if(arr[i]>=arr[pivotPos]) {
                if(arr[j]<arr[pivotPos]) {
                    swapPivot(arr, i, j);
                }
                else j--;
            } else i++;
        }
    }

    private static int pivotPos(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 1; i <=(end - start); i++) {
            if(arr[start] > arr[start + i]) {
                count++;
            }
        }
        return start + count;
    }
}

//31 76 94 112 208 302 330 346 355 400 450 454 484 526 533 581 606 614 695 703 825 845 847 847 851 889 966
