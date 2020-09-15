package dp;

import java.util.Stack;

/**
 * @author chenglee
 * @date 2020/6/9 9:15
 * @description
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == '(') continue;
            if (s.charAt(i-1) == '('){
                dp[i] = 2;
                if (i >= 2){
                    dp[i] += dp[i-2];
                }
            }else if (dp[i-1] > 0){
                int lastSingleIndex = i - dp[i-1] - 1;
                if (lastSingleIndex >= 0 && s.charAt(lastSingleIndex) == '('){
                    dp[i] = dp[i-1] + 2;
                    if (lastSingleIndex - 1 >= 0){
                        dp[i] += dp[lastSingleIndex-1];
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
