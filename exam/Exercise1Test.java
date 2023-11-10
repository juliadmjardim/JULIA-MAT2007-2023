// import necessary packages
import static org.junit.Assert.*;

// Assuming you use JUnit for testing
import org.junit.Test;


public class Exercise1Test {

    @Test(timeout = 2000)
    public void testIsSkewsymmetricEfficiency() {
        for (int n = 100; n <= 2000; n += 100) {
            int[][] matrix = generateSkewsymmetricMatrix(n);

            // Time the isSkewsymmetric operation
            long startTime = System.nanoTime();
            Exercise1.isSkewsymmetric(matrix);
            long endTime = System.nanoTime();

            System.out.println("Matrix size: " + n + "x" + n + ". Time taken (ms): " + (endTime - startTime) / 1_000_000.0);
        }
    }

    // Helper method to generate skew-symmetric matrix
    private int[][] generateSkewsymmetricMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = (int)(Math.random() * 100) + 1;  // random positive number
                matrix[j][i] = -matrix[i][j];
            }
        }
        return matrix;
    }


    public boolean containsString(final Exception e, String keyword)
    {
        if (e.getMessage() != null && e.getMessage().contains(keyword)) 
	{
          System.out.println("The exception is about: " +  keyword);
          return true; 
        }
	else
	{
   	  return false;	
	}
    }

    @Test(timeout = 100)
    public void testNullMatrix() {
        int[][] matrix1 = null;
        boolean r1 = true, r1e = false;

        try {
            r1 = Exercise1.isSkewsymmetric(matrix1); // It should return false 
        } catch (Exception e) {
            // System.out.println("An error occurred: " + e.getMessage());
	    if(containsString(e, "null"))
	    {
	      r1e = true; 
	    }
        }

        assertTrue((r1 == false)||(r1e == true));
    }

    

    @Test(timeout = 500)
    public void testIsSkewsymmetric() {

        int[][] matrix3 = { { 0, 2, 3 }, { -2, 0, 6 }, { -3, -6, 0 } };
        int[][] matrix4 = { { 0, -2, -3 }, { 2, 0, -8 }, { 3, 8, 0 } };

        assertTrue(Exercise1.isSkewsymmetric(matrix3));
        assertTrue(Exercise1.isSkewsymmetric(matrix4));
    }


    public boolean isNotSquareMatrix(int[][] matrix) {
      boolean r = true, re = false;
      try {
          r = Exercise1.isSkewsymmetric(matrix); 
      } catch (Exception e) {

          if(containsString(e, "square matrix"))
          {
            re = true; 
          }
      }
      return (r == false)||(re == true);
    }

    @Test(timeout = 500)
    public void testSquareMatrix() {

        int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] matrix5 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] matrix6 = { { 1, 2, 3 }, { 8, 9, 8 }, { 3, 2 } };

        assertTrue(isNotSquareMatrix(matrix2));
        assertTrue(isNotSquareMatrix(matrix5));
        assertTrue(isNotSquareMatrix(matrix6));
    }
}

