//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 3
public class Exercise3 {
    private static long[] memo;

    public static void main(String[] args) {
        int N= 80;
        memo = new long[N + 1]; // Initializes an array called memo of size N + 1
        for (int i = 0; i <= N; i++) { //Sets all memo to -1
            memo[i] = -1;
        }

        // Testing robustness and computation time
        int[] testCases = {-10, -1, 0, 80, 2, 30, 40, 50, 70, 79};
        for (int n : testCases) {
            try {
                long startTime = System.nanoTime();
                double r = approximateGoldenRatio(n);
                long endTime = System.nanoTime();
                System.out.println("Approximation at position " + n + ": " + r + ", with computation time: " + (endTime - startTime) / 1_000 + " microseconds");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static long nthFibonacci(int n){
        if (n < 0) {
            throw new IllegalArgumentException( n + " is not a valid input. It must be a positive number.");
        }
        //Base Case, since for index 0 and 1 the returned value is the input value
        if (n <= 1) {
            return n;
        }

        //Recursive Case, reruns the function until n<=1
        if (memo[n] != -1) { //Since all memos were set to be -1, if it is not -1 it has already been calculated
            return memo[n]; //If so, return value already stored
        }

        //If not = -1, then calculate it for the first time
        memo[n] = nthFibonacci(n-1) + nthFibonacci(n-2);
        return memo[n];
    }
    public static double approximateGoldenRatio(int n) {
       return (double) nthFibonacci(n) / nthFibonacci(n-1);
    }
}
