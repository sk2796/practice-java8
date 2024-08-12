package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,7,9,11,12,45};
        int target  = 11;
        System.out.println(search(arr, target, 0, arr.length-1));
    }

    private static int search(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid]== target) {
            return mid;
        } else if(arr[mid] > target) {
            return search(arr, target, start, mid);
        }
        else return search(arr, target, mid+1, end);
    }
}
