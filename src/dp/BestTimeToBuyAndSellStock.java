package dp;

import java.util.Arrays;

/**
 * @author chenglee
 * @date 2020/6/3 21:21
 * @description
 */
public class BestTimeToBuyAndSellStock {

    // dp[k][i] = Math.max(dp[k-1][i], prices[i] - prices[j] + dp[k-1][j-1])
    public static int maxProfit21(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++){
            for (int i = 1; i < prices.length; i++){
                int min = prices[0];
                for (int j = 1; j < i; j++){
                    min = Math.min(min, prices[j] - dp[k-1][j-1]);
                }
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][prices.length-1];
    }
    // 每一次都会重复计算 0 - j 的最小值，可以省去， 只比较 prices[j+1] - dp[k-1][j] 即可
    public static int maxProfit22(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++){
            int min = prices[0];
            for (int i = 1; i < prices.length; i++){
                min = Math.min(min, prices[i] - dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][prices.length-1];
    }

    /**
     * 因为每一列的值仅与前一列有关，所以交换for循环位置，将一列一列更新转为一行一行更新
     * 这样就可以将二维数据降维一维数组
     */
    public static int maxProfit23(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[3];
        int[] min = new int[3];
        Arrays.fill(min,prices[0]);
        for (int i = 1; i < prices.length; i++){
            for (int k = 1; k <= 2; k++){
                min[k] = Math.min(min[k], prices[i] - dp[k-1]);
                dp[k] = Math.max(dp[k],prices[i] - min[k]);
            }
        }
        return dp[2];
    }

}
