////Alicia del Prado Rebordinos – 6295981 - Exercise3
public class Exercise3 {
    private static long[] memo;
    /*
    Creates the Fibonacci sequence until the given number.
    Initiates a new memo array with the length of n+1
    and establishes the first two indexes as the two first numbers in the Fibonacci sequence so the operation is possible,
    since the previous two numbers are necessary to calculate the next one.
    Then a loop calculates the rest of the values until the end of the array (n+1),
    starting at 2 because indexes 0 and 1 already have values.
    The number corresponding with the indicated index is returned.
     */
    public static long nthFibonacci(int n) {
        memo = new long[n+1];
        memo[0]=0;
        memo[1]=1;
        for (int a=2; a<n+1; a++){
            memo[a] = memo[a-1]+memo[a-2];
        }
        return memo[n];
    }
    /*
    Approximates the golden ratio of the given number.
    The Fibonacci sequence starts at 1, therefore all values have to be greater than 1
    and this gets handled by returning '-1' in the case n<=1.
    To calculate the golden ratio n has to be divided by the previous index,
    so the both indexes get calculated with the nthFibonacci() method and saved as the variables a and b.
    Therefore, the golden ratio is the division between a and b, in other words: n/n-1.
     */
    public static double approximateGoldenRatio(int n) {
        if (n <= 1){
            System.out.println("n should be greater than 1 for approximation.");
            return -1;
        }
        long a = nthFibonacci(n);
        long b = nthFibonacci(n-1);
        double g = (double) a/b;
        return g;
    }
    //Main method to test.
    public static void main(String[] args) {
        int N = 80;
        memo = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            memo[i] = -1;
        }
        // Testing robustness and computation time
        int[] testCases = {-10, -1, 0, 2, 30, 40, 50, 70, 79, 80};
        for (int n : testCases) {
            long startTime = System.nanoTime();
            double r = approximateGoldenRatio(n);
            long endTime = System.nanoTime();
            System.out.println("Approximation at position " + n + ": " + r + ", with computation time: " + (endTime - startTime) / 1_000 + " microseconds.");
        }
    }
}
