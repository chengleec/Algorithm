package array;

/**
 * @author chenglee
 * @date 2020/7/17 18:00
 * @description
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        boolean[] dp = new boolean[10000];
        for (int i = 1; i <= 5; i++){
            dp[i] = true;
        }
        if (index <= 5) return index;
        int cnt = 4;
        for (int i = 6; i < dp.length; i++){
            for (int j = 2; j < i; j++){
                if (i % j == 0 && dp[j] && dp[i/j]){
                    dp[i] = true;
                    cnt ++;
                    break;
                }
            }
            if (cnt == index) return i;
        }
        return 0;
    }
}
