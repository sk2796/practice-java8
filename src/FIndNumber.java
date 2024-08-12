public class FIndNumber {
    public static void main(String[] args) {
        int n = 4;
        int k = 6;
        int num = solve(n,k);
        System.out.println(num);
    }

    private static int solve(int n, int k) {
        if(n==1 && k==1) {
            return 0;
        }
        else {
            int mid = (int) (Math.pow(2, n-1)/2);
            if(k<=mid) {
                return solve(n-1, k);
            }
            else return complement(solve(n-1, k-mid));
        }
    }

    private static int complement(int solve) {
        return solve ==1 ? 0 : 1;
    }
}
