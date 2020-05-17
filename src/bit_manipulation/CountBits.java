package bit_manipulation;

/**
 * @author chenglee
 * @date 2020/5/17 7:58
 * @description
 */
public class CountBits {
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++){
            int val = i;
            while (val > 0) {
                val &= val - 1;
                res[i]++;
            }
        }
        return res;
    }
}
