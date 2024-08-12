package sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] input = new int[]{123,542,115,32,231,534,65,767,99};
        int max = Arrays.stream(input).max().getAsInt();
        int exponent = 1;
        while(max != 0) {
            max = max/10;
            radixSort(input, exponent);
            exponent = exponent * 10;
        }
        System.out.println(Arrays.toString(input));
    }

    private static void radixSort(int[] input, int exponent) {
        int[] freqArray = new int[10];
        for (int i = 0; i < input.length; i++) {
            int pos = (input[i]/exponent) % 10;
            freqArray[pos] = freqArray[pos]+1;
        }
        System.out.println("INPUTS");
        System.out.println(Arrays.toString(freqArray));
        for (int i = 1; i < freqArray.length; i++) {
            freqArray[i] = freqArray[i-1] + freqArray[i];
        }
        countSortOnArray(input, freqArray, exponent);
        System.out.println("FREQ-ARRAY");
        System.out.println(Arrays.toString(freqArray));
    }

    private static void countSortOnArray(int[] input, int[] freqArray, int exponent) {
        int[] sortedArray = new int[input.length];
        for (int i = input.length-1; i>=0; i--) {
            int pos = freqArray[(input[i]/exponent) % 10];
            sortedArray[pos - 1] = input[i];
            freqArray[(input[i]/exponent) % 10]--;
        }
        System.arraycopy(sortedArray, 0, input, 0, sortedArray.length);
    }
}
