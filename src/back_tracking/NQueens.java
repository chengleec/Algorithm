package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/6/16 10:02
 * @description
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        dfs(res,board,0);
        return res;
    }

    public void dfs(List<List<String>> res, char[][] board, int col){
        if (col == board.length){
            res.add(transform(board));
            return;
        }
        for (int i = 0; i < board.length; i++){
            if(!isValid(board,i,col)) continue;
            board[i][col] = 'Q';
            dfs(res,board,col+1);
            board[i][col] = '.';
        }
    }

    public boolean isValid(char[][] board, int x, int y){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < y; j++){
                if ((i == x || Math.abs(i-x) == Math.abs(j-y)) && board[i][j] == 'Q')
                    return false;
            }
        }
        return true;
    }
    public List<String> transform(char[][] board){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            String str = new String(board[i]);
            list.add(str);
        }
        return list;
    }
}
