package sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] input = new int[]{9,7,4,2,6,2,5,1,6,3,5,8,9,5,3};
        countSort(input);
        System.out.println(Arrays.toString(input));
    }

    private static void countSort(int[] input) {
        int max = Arrays.stream(input).max().getAsInt();
        int[] freq = getFrequesncyArray(input, max);
        freq = getCummulativeSum(freq);
        System.out.println(Arrays.toString(input));
        System.out.println("Frequency Array :"+Arrays.toString(freq));
//        System.out.println("Cummulative sum Array :"+Arrays.toString(cummSum));
        int[] sortedArray = countSortArray(input, freq);
        System.out.println("Sorted Array :"+Arrays.toString(sortedArray));
    }

    private static int[] countSortArray(int[] input, int[] cummSum) {
        int[] sortedArray = new int[input.length];
        for (int i = input.length-1; i >=0 ; i--) {
            int index = cummSum[input[i]];
            sortedArray[index-1] = input[i];
            cummSum[input[i]]--;
        }
        return  sortedArray;
    }

    private static int[] getCummulativeSum(int[] freq) {
        int[] sum = new int[freq.length];
        sum[0] = freq[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + freq[i];
        }
        return sum;
    }

    private static int[] getFrequesncyArray(int[] input, int max) {
        int[] freqArray = new int[max+1];
//        System.out.println(Arrays.toString(freqArray));
        for (int i = 0; i < input.length; i++) {
            freqArray[input[i]] = freqArray[input[i]] + 1;
        }
        return freqArray;
    }
}
