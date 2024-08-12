package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,1,23,2,45,34,6,90,0,46,87,7};
        System.out.println(arr.length);
        boolean swapped;
        for(int i = 0; i < arr.length-1; i++) {
            swapped = false;
            for(int j= 0; j<arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
//                    System.out.println("j "+j);
                    swap(arr, j, j + 1);
                    swapped = true;
                    System.out.println("After iteration : " + Arrays.toString(arr) );
                }
            }
            System.out.println("i "+i);
            if(!swapped)
                break;

            System.out.println("After iteration : " + i + " " + Arrays.toString(arr) );
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
