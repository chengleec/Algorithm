package dp;

import java.util.Stack;

/**
 * @author chenglee
 * @date 2020/6/9 9:15
 * @description
 */
public class LongestValidParentheses {
    /**
     * if s(i) == '(':
     *      dp[i] = 0;
     *      cnt ++;
     * else if s(i) == ')' && cnt > 0:
     *      dp[i] = dp[i-1] + 2;
     *      dp[i] += dp[i-dp[i]];
     *      cnt --;
     */
    public static int longestValidParenthesesByDP(String s) {

        int res = 0, cnt = 0;
        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ')' && cnt > 0){
                dp[i] = dp[i-1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                res = Math.max(res, dp[i]);
                cnt --;
            }else if (s.charAt(i) == '(') {
                cnt ++;
            }
        }
        return res;
    }

    public static int longestValidParenthesesByStack(String s) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                st.push(i);
            else {
                st.pop();
                if (st.isEmpty()) st.push(i);
                else res = Math.max(res, i - st.peek());
            }
        }
        return res;
    }
}
