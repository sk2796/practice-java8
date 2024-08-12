import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        int[] a = {6,1,6,5,3,2,2,5,0,5,6,0};
        int result = tripletSum(a, 5);
        System.out.println(result);
    }

    private static int tripletSum(int[] input, int target) {
        int count = 0;
        Arrays.sort(input);
        for (int i = 0; i < input.length-3; i++) {
            int high = input.length-1;
            int afterFirst = target - input[i];
            int low = i+1;
            while(low<high) {
                if (input[low] + input[high] == afterFirst) {
                    count++;
                    System.out.println(input[i] + " " + input[low] + " " + input[high]);
                    while (input[high] == input[high-1]) {
                        count++;
                        System.out.println(input[i] + " " + input[low] + " " + input[high]);
                        high--;
                    }
                    while(input[low] == input[low+1]) {
//                        count++;
                        low++;
                    }
                    high--;
                }
                while (input[low] + input[high] > afterFirst && low < high) {
                    high--;
                }
                if (input[low] + input[high] < afterFirst && low < high) {
                    low++;
                }
            }
        }
        return count;
    }
}
