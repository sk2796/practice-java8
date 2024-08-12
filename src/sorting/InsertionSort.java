package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8,4,3,6,9,2,1};
        for(int i =1; i< arr.length; i++) {
            for (int j = i-1; j>=0; j--) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println(Arrays.toString(arr));
                }
                else break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
