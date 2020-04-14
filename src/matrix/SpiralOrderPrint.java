package matrix;

import java.util.ArrayList;
import java.util.List;

//转圈打印矩阵
public class SpiralOrderPrint {
    void spiralOrderPrintHelper(int[][] matrix, List<Integer> res, int tr, int tc, int dr, int dc) {
        if(tr == dr){
            for(int i=tc;i<=dc;i++){
                res.add(matrix[tr][i]);
            }
        }else if(tc == dc){
            for(int i=tr;i<=dr;i++){
                res.add(matrix[i][tc]);
            }
        }else{
            int curc = tc, curr = tr;
            while(curc != dc) res.add(matrix[curr][curc++]);
            while(curr != dr) res.add(matrix[curr++][curc]);
            while(curc != tc) res.add(matrix[curr][curc--]);
            while(curr != tr) res.add(matrix[curr--][curc]);
        }
    }
    public List<Integer> spiralOrderPrint(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int tr = 0, tc = 0, dr = matrix.length-1, dc = matrix[0].length-1;
        while (tr <= dr && tc <= dc) {
            spiralOrderPrintHelper(matrix, res, tr++, tc++, dr--, dc--);
        }
        return res;
    }
}
