import java.lang.reflect.Field;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Exercise3Test {
    
    private static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;
    private static final double THRESHOLD = 0.0001;
    private static int N = 80;
    
    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException{

        Field field = Exercise3.class.getDeclaredField("memo");
        field.setAccessible(true);

	long[] memoArray = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            memoArray[i] = -1;
        }
        field.set(null, memoArray);  // Setting the static field

    }
    
    // (1) Testing the robustness of nthFibonacci and approximateGoldenRatio
    @Test(timeout = 200)
    public void testNegativeFibonacci() {
        long result = Exercise3.nthFibonacci(-1);
        assertEquals(-1, result);  
    }

    // @Test(expected = ArrayIndexOutOfBoundsException.class)
    @Test(timeout = 200)
    public void testNegativeApproximation() {
        double result = Exercise3.approximateGoldenRatio(-1);
        assertEquals(-1, result, 0.001);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class, timeout = 1500)
    public void testExceedLimitFibonacci() {
        Exercise3.nthFibonacci(N + 1);
    }

    @Test(timeout = 300)
    public void testLowValueApproximation() {
        assertEquals(-1, Exercise3.approximateGoldenRatio(0), THRESHOLD);
        assertEquals(-1, Exercise3.approximateGoldenRatio(1), THRESHOLD);
    }
    
    // (2) Testing efficiency of nthFibonacci with memoization
    @Test(timeout = 2000)
    public void testEfficiency() {
        int[] testCases = {2, 30, 40, 50, 70, 79}; 

        double r = Exercise3.approximateGoldenRatio(80);

        for (int n : testCases) {
            long startTime = System.nanoTime();
            Exercise3.approximateGoldenRatio(n);
            long endTime = System.nanoTime();
            long elapsedTime = (endTime - startTime) / 1_000;
            
            assertTrue(elapsedTime == 0);
        }
    }
    
    // (3) Testing correctness of approximateGoldenRatio with respect to the actual golden ratio
    @Test(timeout = 2000)
    public void testApproximationAccuracy() {
        for (int n = 20; n <= 79; n++) {
            double ratio = Exercise3.approximateGoldenRatio(n);
            assertTrue(Math.abs(GOLDEN_RATIO - ratio) < THRESHOLD);
        }
    }
}
