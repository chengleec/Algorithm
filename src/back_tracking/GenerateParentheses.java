package back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/6/15 9:45
 * @description
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,n,0,"");
        return res;
    }
    private static void helper(List<String> res, int left, int right, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) helper(res,left - 1, right + 1, s + "(");
        if (right > 0) helper(res,left, right - 1, s + ")");
    }
}
