public class BinarySearchNormal {
    public static void main(String[] args) {
        int[] arr = {1,3,7,9,11,12,45};
        int target  = 1;
        System.out.println(search(arr, target, 0, arr.length-1));
    }

    private static int search(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] > target) {
                end = mid-1;
            }
            else start = mid+1;
        }
        return -1;
    }
}
