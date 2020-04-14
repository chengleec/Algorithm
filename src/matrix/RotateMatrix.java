package matrix;

//将矩阵顺时针旋转90°
public class RotateMatrix {
    public void rotateMatrixHelper(int[][] matrix, int tr, int tc, int dr, int dc){
        int times = dr - tr;
        for(int i=0;i<times;i++){
            int tmp = matrix[tr][tc+i];
            matrix[tr][tc+i] = matrix[dr-i][tc];
            matrix[dr-i][tc] = matrix[dr][dc-i];
            matrix[dr][dc-i] = matrix[tr+i][dc];
            matrix[tr+i][dc] = tmp;
        }
    }
    public void rotateMatrix(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int tr = 0, tc = 0, dr = m-1, dc = n-1;
        while(tr < dr){
            rotateMatrixHelper(matrix,tr++,tc++,dr--,dc--);
        }
    }
}
