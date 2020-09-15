package math;

/**
 * @author chenglee
 * @date 2020/9/12 9:02
 * @description
 */
public class LeastCommonMultiple {
    // 最大公约数
    public int gcd(int p, int q){
        if (q == 0) return p;
        return gcd(q, p % q);
    }
    public int lcm(int p, int q){
        int pq = p * q;
        return pq / gcd(p, q);
    }
}
