package string;

/**
 * @author chenglee
 * @date 2020/6/19 9:13
 * @description：双指针问题
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, cnt = 0, startIndex = 0, minLen = Integer.MAX_VALUE;
        int[] hash = new int[128];

        for (int i = 0; i < t.length(); i++){
            hash[t.charAt(i)]++;
            cnt ++;
        }

        while (right < s.length()){
            // 如果是 t 中的字母 cnt --
            if (hash[s.charAt(right)] > 0)
                cnt --;
            // 所有字母都 -1，如果该字母不是 t 中的，会变成负数
            hash[s.charAt(right)]--;
            right ++;
            // 当 cnt == 0 时，表示 t 中的字母都找到了，包含在 left - right 中
            while (cnt == 0){
                // 更新最小长度
                if (right - left < minLen){
                    minLen = right - left;
                    startIndex = left;
                }
                // 所有字母 +1
                hash[s.charAt(left)]++;
                // 如果某个字母 > 0 了，表明这个字母是 t 中的字母，cnt ++
                if (hash[s.charAt(left)] > 0) cnt ++;
                left ++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
