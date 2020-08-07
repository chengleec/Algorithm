package dp;

/**
 * @author chenglee
 * @date 2020/6/9 19:48
 * @description
 */
public class RegularExpressionMatching {
    /**
     * 1. 如果 s[i] = p[j]：dp[i][j] = dp[i-1][j-1];
     * 2. 如果 p[j] = '.'：dp[i][j] = dp[i-1][j-1];
     * 3. 如果 p[j] = '*'：
     *      (1) 表示空 (p[j-1] != s[i] && p[j-1] != '.')：dp[i][j] = dp[i][j-2]
     *      (2) 表示多个字母 (p[j-1] == s[i] || p[j-1] == '.')：dp[i][j] = dp[i-1][j]
     */
    public static boolean isMatch(String s, String p) {
        // 如果 s 或者 p 不存在，返回 false
        if (s == null || p == null) return false;

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // 如果 s 或者 p 都为空字符串，返回 true
        dp[0][0] = true;
        // 如果 p 为空，返回 false
        for (int i = 1; i < m+1; i++){
            dp[i][0] = false;
        }
        // 如果 s 为空，p 只有一种情况可以匹配成功：#*#*，即偶数位为 *，表示 0 个前面的字母
        for (int j = 2; j < n+1; j += 2){
            if (p.charAt(j-1) == '*' && dp[0][j-2])
                dp[0][j] = true;
        }

        for (int i = 1; i < m+1; i++){
            for (int j = 1; j < n+1; j++){
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1) == '*'){
                    if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.')
                        dp[i][j] = dp[i][j-2];
                    else if (p.charAt(j-1) == '*')
                        dp[i][j] = (dp[i][j - 2] || dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
