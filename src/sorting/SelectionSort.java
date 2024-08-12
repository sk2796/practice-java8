package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,1,23,2,45,34,6,90,0,46,87,7};
        for(int i = arr.length-1; i>0;i--) {
            int maxIndex = 0;
            for(int j =1; j<=i; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
