
//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 1

public class Exercise1 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] nonSquareMatrix = { { 1, 2, 3 }, { 8, 9, 8 }, { 3, 2 } };
        int[][] nullmatrix = null;

        try {
            if (isSkewsymmetric(nullmatrix)) {
                System.out.println("It's skew-symmetric.");
            } else {
                System.out.println("It's not skew-symmetric.");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //to return a string when the method return type is a boolean, an exception can be used
            // exception was implemented according to the course book, (DJE) section 8.3
                // syntax for multi-catch was found at: https://stackoverflow.com/questions/3495926/can-i-catch-multiple-java-exceptions-in-the-same-catch-clause
    }

    public static boolean isSkewsymmetric(int[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("The matrix is null"); //Checks for null exception
        }
        if (matrix.length == matrix[0].length) {
            throw new IllegalArgumentException("The matrix is not square"); //Checks for non-square exception
        }

        for (int row = 0; row < matrix.length; row++) { //Iterates through rows
            for (int col = row; col < matrix.length; col++) { //Iterates through columns
                if (matrix[row][col] != -matrix[col][row]) { //Checks if corresponding element is its negation
                    return false;
                }
            }
        }

        return true;
    }
}