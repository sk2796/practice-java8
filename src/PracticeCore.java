import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PracticeCore {
    public static void main(String[] args) {
        int[] arr = {1,3,6,2,5,4,3,2,4};
        int[] a = {1,2,3,4,5,6,7};
        int[] ar = {2,2,2,2};
//        intersection(arr, ar);
//        sort01(arr);
//        sort012(ar);
//        int result = returnUnique(arr);
//        int result = returnUniqueXOR(arr);

//        int[] a = new int[ar.length-1];
//        System.arraycopy(ar,1, a, 0, a.length);
////        a[a.length-1] = 5;
//        System.out.println(Arrays.toString(a));
//        int n = 54;
//        System.out.println(n%10);
//        int[] res = indexOfTwoSum(ar, 20);
//        int result = numberOfPairs(arr, 7);
//        int result = tripletSum(a, 12);
//        System.out.println(result);
//        System.out.println(Arrays.toString(res));

    }

    public static int tripletSum(int[] arr, int num) {
        //Your code goes here
        int count = 0;
        for (int i = 0; i < arr.length-2; i++) {
            int afterFirst = num-arr[i];
            for (int j = i+1; j < arr.length-1; j++) {
                int afterSecond = afterFirst - arr[j];
                for (int k = j+1; k < arr.length; k++) {
                    if(afterSecond -  arr[k]== 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int numberOfPairs(int[] arr, int target) {
        int count = 0;
//        Arrays.sort(arr);
//        int leftIndex= 0, rightIndex = arr.length-1;
//        while(leftIndex<rightIndex) {
//            if(arr[leftIndex]+ arr[rightIndex]== target) {
//                System.out.println(arr[leftIndex] +" "+arr[rightIndex]);
//                count++;
//                leftIndex++;
//            } else if(arr[leftIndex]+ arr[rightIndex]>target) {
//                rightIndex--;
//            }
//            else leftIndex++;
//        }
//        for (int i = 0; i < arr.length; i++) {
//
//        }
        for (int i = 0; i < arr.length-1; i++) {
            int comp = target - arr[i];
            for (int j = i; j < arr.length; j++) {
                if(i!=j) {
                    if(comp == arr[j]) {
                        count++;
                        System.out.println(arr[i] +" "+ arr[j]);
                    }
                }
            }
        }
        return count;
    }

    private static void intersection(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length> arr2.length ? arr2.length : arr1.length];
        int k =0;
        Arrays.sort(arr1);
        //1st approach
        Arrays.sort(arr2);
        int i = 0, j =0;
        while(i<arr1.length && j <arr2.length) {
            if(arr1[i]== arr2[j]) {
                res[k] = arr1[i];
                System.out.print(arr1[i] + " ");
                k++; i++; j++;
            }
            else if(arr1[i]> arr2[j]) {
                j++;
            }
            else i++;
        }

        //2nd approach
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr2.length; j++) {
//                if(arr1[i]== arr2[j]) {
//                    System.out.print(arr2[j] + " ");
//                    // res[k] = arr2[j];
//                    // k++;
//                    arr2[j] = -1;
//                    break;
//                }
//            }
//        }
    }

    private static int returnUniqueXOR(int[] arr) {
        int xor = 0;
        for(int x : arr) {
            xor = xor ^ x;
        }
        return xor;
    }

    private static int returnUnique(int[] arr) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int x : arr) {
            if(hmap.containsKey(x)) {
                hmap.put(x, hmap.get(x)+1);
            }else hmap.put(x,1);
        }
        System.out.println(hmap);
        return hmap.entrySet().stream().filter(x -> x.getValue()==1)
                .map(Map.Entry::getKey).findFirst().get();
    }

    private static int[] indexOfTwoSum(int[] ar, int x) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            int comp = x -ar[i];
            if(hmap.containsKey(comp)) {
                return new int[] {hmap.get(comp), i};
            }
            else hmap.put(ar[i], i);
        }
        return new int[0];
    }

    private static void sort012(int[] ar) {
        int moveStart = 0;
        int moveLast = ar.length-1;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]==0) {
                if(moveStart<i) {
                    int temp = ar[moveStart];
                    ar[moveStart] = ar[i];
                    ar[i] = temp;
                    i--;
                }
                moveStart++;
            } else if(ar[i]==2) {
                if(i<moveLast) {
                    int temp = ar[moveLast];
                    ar[moveLast] = ar[i];
                    ar[i] = temp;
                    i--;
                }
                moveLast--;
            }
        }
        System.out.println(Arrays.toString(ar));
    }

    private static void sort01(int[] arr) {
        int move = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0) {
                if (move == i) {
                    move++;
                } else {
                    int temp = arr[i];
                    arr[i] = arr[move];
                    arr[move] = temp;
                    move++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
