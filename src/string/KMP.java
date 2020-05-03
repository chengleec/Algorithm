package string;

/**
 * @author chenglee
 * @date 2020/5/3 8:33
 * @description：字符串匹配算法
 */
public class KMP {
    //暴力法
    public int ViolentMatch(String s, String p){
        int i = 0, j = 0;
        while(i < s.length() && j < p.length()){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }
            if (j == p.length()) return i;
            i = i - j + 1;
            j = 0;
        }
        return -1;
    }
    public int KMP(String s, String p) {
        int i = 0, j = 0;
        int[] next = getNext(p);
        while (i < s.length() && j < p.length()) {
            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                j = next[j];
            }
        }
        if (j == p.length())
            return i - j;
        return -1;
    }
    public int[] getNext(String p) {
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
        int[] next = new int[p.length()];
        int k = -1, j = 0;
        next[0] = -1; // next数组中第一位next[0]为-1
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
