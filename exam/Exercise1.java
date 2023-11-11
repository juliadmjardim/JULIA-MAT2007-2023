//Alicia del Prado Rebordinos – 6295981 - Exercise1
public class Exercise1 {
    public static boolean isSkewsymmetric(int[][] matrix) {
        //If the input is null it will be returned false and the method code doesn't continue.
        if (matrix == null){
            System.out.println("The input matrix is null.");
            return false;
        }
        //The number of rows is counted and saved as a variable called r.
        int r = matrix.length;
       /*
        Checks if the matrix is square i.e. the number of columns equals the number of rows.
        It opens a loop that iterates through each row
        and saves the number of columns as the length of that specific row.
        If the number of columns doesn't equal the number of rows the matrix isn't square.
        Otherwise the method code continues running.
        */
        for (int a=0; a<r; a++){
            int c = matrix[a].length;
            if (r != c){
                System.out.println("The input matrix is not a square matrix.");
                return false;
            }
        }
        /*
        Checks if the matrix is NOT skew-symmetric.
        Opens two loops:
        - Outer loop goes through the number of rows.
        - Inner loop goes through the number of columns, measured by the number of integers on the first row.
        Then it checks if the corresponding index in the matrix isn't equal to the negative opposite-positioned index.
        If all the indexes in the matrix met this statement then the matrix would be skew-symmetric.
         */
        for (int a=0; a<r; a++){
            for (int b=0; b<matrix[0].length; b++){
                if (matrix[a][b] != -matrix[b][a]){
                    return false;
                }
            }
        }
        //If the method hasn't returned false by now it means the matrix is skew-symmetric.
        return true;
    }
}
