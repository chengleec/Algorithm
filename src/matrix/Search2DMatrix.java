package matrix;

public class Search2DMatrix {
    public boolean search2DMatrix(int[][] matrix, int target){
        if(matrix.length == 0) return false;
        int row = 0, col = matrix[0].length-1;
        while(col >= 0 && row < matrix.length){
            if(matrix[row][col] == target) return true;
            else if(target < matrix[row][col]) col --;
            else if(target > matrix[row][col]) row ++;
        }
        return false;
    }
}
