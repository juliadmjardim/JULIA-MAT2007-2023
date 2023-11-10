// import necessary packages
import static org.junit.Assert.*;

// Assuming you use JUnit for testing
import org.junit.Test;


public class Exercise1BasicTest {
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

    @Test
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

    

    @Test
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

    @Test
    public void testSquareMatrix() {

        int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] matrix5 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] matrix6 = { { 1, 2, 3 }, { 8, 9, 8 }, { 3, 2 } };

        assertTrue(isNotSquareMatrix(matrix2));
        assertTrue(isNotSquareMatrix(matrix5));
        assertTrue(isNotSquareMatrix(matrix6));
    }
}

