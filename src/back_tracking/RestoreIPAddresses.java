package back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/8/9 9:13
 * @description
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer(s);
        backtracking(sb,res,0,-1);
        return res;
    }
    public void backtracking(StringBuffer sb, List<String> res, int pointNum, int index){
        if (index == sb.length() - 1) return;
        if (pointNum == 3){
            if (isValid(sb, index+1, sb.length())){
                res.add(sb.toString());
            }
            return;
        }
        for (int i = index+1; i < sb.length(); i++){
            if (isValid(sb,index+1,i+1)){
                sb.insert(i + 1, ".");
                backtracking(sb,res,pointNum+1,i+1);
                sb.deleteCharAt(i + 1);
            }
        }
    }
    public boolean isValid(StringBuffer sb, int left, int right){
        if (left != right-1 && sb.charAt(left) == '0') return false;
        long num = Long.valueOf(sb.substring(left, right));
        if (num < 0 || num > 255) return false;
        return true;
    }
}
