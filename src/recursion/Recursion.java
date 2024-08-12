package recursion;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recursion {
    public static void main(String[] args) {
        int  n = 6;
        int[] arr = {61,79,3,97,81,81,45,62,81,21,72,66,81};;
//        int result = fact(n);
//        int result = sumOfNatural(n);
//        int result = numOfDigits(n);
//        System.out.println(fibonacci(n));
//        System.out.println(isArraySorted(arr));
//        System.out.println(findANumber(arr, 7));
//        int result = sumOfArray(arr);
//        int result = firstIndex(arr, 9, 0);
//        int result = lastIndexFinder(arr, 61, 0, -1);
//        allIndex(arr, 81);
//        int[] res = allIndexDiffApproach(arr, 81);
//        int result = countZerosRec(0);
//        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.toString(new int[5]));
//        double result = findGeometricSum(2);
//        int result = sumOfDigits(37745);
//        String str = "xabtbax";
//        String result = replacePi("xpix");
//        String result = removeX("xhwjbxhixhjhxijbx");
//        int result = convertStringToInt("67483", 0);
//        System.out.println(isPallindrome(str));
//        String result = addStars("hello");
//        String result = removeConsecutiveDuplicates("aabbbbccchello");
//        String result = replaceCharacter("cncnchchjckcd", 'c', 'x');
        int[] a = new int[] {97,3,81,45,32,65,21,2,43};
//        mergeSort(a, 0, a.length-1);
        String[] result = returnSubsequence("xyz");
        System.out.println(Arrays.toString(result));
    }

    private static String[] returnSubsequence(String str) {
        if(str.length()==0) {
            return new String[]{""};
        }
        String[] smallAns = returnSubsequence(str.substring(1));
        String[] res = new String[smallAns.length * 2];
        System.arraycopy(smallAns, 0, res, 0, smallAns.length);

        for (int i = 0; i < smallAns.length; i++) {
            res[smallAns.length + i] = str.charAt(0) + smallAns[i];
        }
        return res;
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(start>=end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        mergeFinal(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeFinal(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int j = mid+1;
        int[] res = new int[end - start + 1];
        int i = start;
        int k = 0;
        while(i<=mid  && j<=end ) {
            if(arr[i] > arr[j]) {
                res[k] = arr[j];
                j++; k++;
            } else {
                res[k] = arr[i];
                i++; k++;
            }
        }
        while(i<=mid) {
            res[k] = arr[i];
            i++; k++;
        }
        while(j<=end) {
            res[k] = arr[j];
            j++; k++;
        }
        System.arraycopy(res, 0, arr, start, res.length);
    }

    private static String removeConsecutiveDuplicates(String str) {
        if(str.length() == 1) {
            return str;
        }
        if(str.charAt(0) != str.charAt(1)) {
            return str.charAt(0) + removeConsecutiveDuplicates(str.substring(1));
        } else return removeConsecutiveDuplicates(str.substring(1));
    }

    private static String replaceCharacter(String str, char c, char x) {
        if(str.length()== 1) {
            if(str.charAt(0) == c) {
                return String.valueOf(x);
            }
            else return str;
        }
        if(str.charAt(0) == c) {
            return x + replaceCharacter(str.substring(1), c, x);
        }
        return str.charAt(0) + replaceCharacter(str.substring(1), c, x);
    }

    private static String addStars(String str) {
        if(str.length() == 1) {
            return str;
        }
        if(str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + addStars(str.substring(1));
        }
        return str.charAt(0) + addStars(str.substring(1));
    }

    private static int convertStringToInt(String str, int result) {
        if(str.length() == 1) {
            return (result * 10)  + Integer.parseInt(str);
        }
        if(str.length()>1) {
            result = (result *10) + Integer.parseInt(String.valueOf(str.charAt(0)));
        }
        return convertStringToInt(str.substring(1), result);
    }

    private static String removeX(String str) {
        if(str.length()==1) {
            if(str.charAt(0)=='x') {
                return "";
            }
            return str;
        }
        if(str.charAt(0) != 'x') {
            return str.charAt(0) + removeX(str.substring(1));
        }
        return removeX(str.substring(1));
    }

    private static String replacePi(String str) {
        if(str.length() == 1) {
            return str;
        }
        if(str.charAt(0) == 'p') {
            if(str.charAt(1) == 'i') {
                if(str.length() > 2) {
                    return "3.14" + replacePi(str.substring(2));
                }
                else return "3.14";
            }
        }
        return str.charAt(0) + replacePi(str.substring(1));
    }

    private static int sumOfDigits(int n) {
        if(n<9) {
            return n;
        }
        return n%10 + sumOfDigits(n/10);
    }

    private static boolean isPallindrome(String str) {
         if(str.length() <= 1 ) {
             return true;
         }
         if(str.charAt(0) != str.charAt(str.length()-1)) {
             return false;
         }
         return isPallindrome(str.substring(1, str.length()-1));
    }

    public static double findGeometricSum(int k){
        // Write your code here
        if(k == 0) {
            return 1;
        }
        return Math.pow(0.5, k) + findGeometricSum(k-1);

    }

    public static int countZerosRec(int input){
        if(input ==0) {
            return 1;
        }
        // Write your code here
        if(input/10==0) {
            return 0;
        }
        if(input%10 == 0) {
            input = input/10;
            return 1 + countZerosRec(input);
        }
        input = input/10;
        return countZerosRec(input);
    }

    private static int[] allIndexDiffApproach(int[] arr, int x) {
        int[] res = new int[0];
        return allIndexDiffApproachHelper(arr, x, 0, res);
    }

    private static int[] allIndexDiffApproachHelper(int[] arr, int x, int startIndex, int[] res) {
        if (arr.length == 1) {
            int[] newRes = new int[res.length+1];
            if (arr[0] == x) {
                if (res.length == 0) {
                    newRes[0] = startIndex;
                    return newRes;
                } else {
                    System.arraycopy(res, 0, newRes, 0, newRes.length-1);
                    newRes[res.length] = startIndex;
                }
            }
            return newRes;
        }
        int[] smallArr = new int[arr.length-1];
        System.arraycopy(arr, 1, smallArr, 0, arr.length-1);
        if (arr[0] == x) {

            int[] newRes = new int[res.length+1];
            if(res.length>=1) {
                System.arraycopy(res, 0, newRes, 0, newRes.length-1);
            }
            newRes[newRes.length-1] = startIndex;
            return allIndexDiffApproachHelper(smallArr, x, startIndex + 1, newRes);
        } else return allIndexDiffApproachHelper(smallArr, x, startIndex + 1, res);
    }

    private static void allIndex(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==x) {
                count++;
            }
        }
        int[] res = new int[count];
        res = allIndexHelper(arr, x, res, 0, 0);
        System.out.println(Arrays.toString(res));
    }

    private static int[] allIndexHelper(int[] arr, int x, int[] res, int currIndex, int lastIndex) {
        if(currIndex == arr.length-1) {
            if(arr[currIndex] == x) {
                res[lastIndex] = currIndex;
            }
            return res;
        }
        if(arr[currIndex] == x) {
            res[lastIndex] = currIndex;
            lastIndex++;
        }
        return allIndexHelper(arr, x, res, currIndex+1, lastIndex);
    }

    private static int lastIndexFinder(int[] arr, int x, int currIndex, int lastIndex) {
        if(currIndex == arr.length) {
            return lastIndex;
        }
        if(arr[currIndex] == x) {
            lastIndex = currIndex;
        }
        return lastIndexFinder(arr, x, currIndex+1, lastIndex);
    }

    private static int firstIndex(int[] arr, int x, int startIndex) {
        if(arr.length == 1) {
            if(arr[0]==x) {
                return startIndex;
            }
            else return -1;
        }
        int[] smallArr = new int[arr.length-1];
        System.arraycopy(arr, 1,smallArr, 0, smallArr.length);
        if(arr[0] == x) {
            return startIndex;
        }
        return firstIndex(smallArr, x, startIndex+1);
    }

    private static boolean findANumber(int[] input, int x) {
        if(input.length==1) {
            if(input[0]==x) {
                return true;
            }
            return false;
        }
        int[] smallArr = new int[input.length-1];
        System.arraycopy(input, 1, smallArr, 0, smallArr.length);
        boolean check = false;
        if(input[0]==x) {
            check = true;
        }
        return check || findANumber(smallArr, x);
    }

    private static int sumOfArray(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }
        int[] smallArr = new int[arr.length -1];
        System.arraycopy(arr, 1, smallArr, 0, arr.length-1);
         return arr[0] + sumOfArray(smallArr);
    }

    private static boolean isArraySorted(int[] arr) {
        if(arr.length == 1) {
            return true;
        }
        if(arr[0]> arr[1]) {
            return false;
        }
        int[] smallArr = new int[arr.length-1];
        for(int i=0; i< smallArr.length; i++) {
            smallArr[i] = arr[i+1];
        }
        return isArraySorted(smallArr);
    }

    private static int fibonacci(int n) {
        if(n ==0 || n==1) {
            return n;
        }
        return fibonacci(n -1) + fibonacci(n-2);
    }

    private static int numOfDigits(int n) {
        if(n/10 == 0) {
            return 1;
        }
        return  1 + numOfDigits(n/10);

    }

    private static int sumOfNatural(int n) {
        if(n==1) {
            return 1;
        }
        return n + sumOfNatural(n-1);
    }

    private static int fact(int n) {
        if(n==1) {
            return 1;
        }
        return n * fact(n-1);
    }
}
