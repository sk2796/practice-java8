import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,11,12,17};
        int index = 4;
        int[] result = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            if(x == arr[i]) {
//                index = i;
//            }
//        }
        int k = 0;
        while(k <= arr.length-1) {
            if(k +index < arr.length) {
                result[k] = arr[k +index];
                k++;
            }
            else {
                int i = (k + index) - arr.length ;
                result[k] = arr[i];
                k++;
            }
        }
        System.arraycopy(result, 0, arr, 0, arr.length);
        System.out.println(Arrays.toString(result));
    }
}
