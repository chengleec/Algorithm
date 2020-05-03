package string;

/**
 * @author chenglee
 * @date 2020/5/2 9:10
 * @description：求最长回文字符串
 */
public class LongestPalindromicString {
    //暴力法
    public String palindromic1(String s){
        String res = "";
        int start = 0, end = 0;
        //起始地址
        for (int i = 0; i < s.length(); i++) {
            //结束地址
            for (int j = i+1; j < s.length(); j++){
                start = i;
                end = j;
                while(start < end && s.charAt(start) == s.charAt(end)){
                    start ++;
                    end --;
                }
                if (start >= end && j - i + 1 > res.length()){
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
    //中心扩展法
    public String palindromic2(String s){
        if (s.isEmpty() || s.length() == 1) return s;

        String res = "", str = "";
        for(int i = 0; i < s.length(); i++){
            String s1 = palindromic2Help(s, i, i);
            String s2 = palindromic2Help(s, i,i + 1);
            str = s1.length() > s2.length() ? s1 : s2;
            res = str.length() > res.length() ? str : res;
        }
        return res;
    }
    public String palindromic2Help(String s, int start, int end){
        while(start > 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start --;
            end ++;
        }
        return start < end ? s.substring(start + 1, end) : "";
    }

    // Manacher算法
    public String palindromic3(String s){

        StringBuffer str = new StringBuffer(s);
        //填充字符串
        for (int i = 0; i < str.length(); i += 2){
            str.insert(i,'#');
        }
        str.append("#");

        //分别代表最右端、当到达最右端是的中心位置、最大长度、取得最大长度时的中心
        int right = 0, center = 0, maxlen = 0, index = 0;
        int[] len = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (right > i) len[i] = Math.min(len[2 * center - i], right - i);
            else len[i] = 1;
            while(i - len[i] >= 0 && i + len[i] < str.length() && str.charAt(i-len[i])== str.charAt(i+len[i])){
                len[i] ++;
            }
            if(i + len[i] > right){
                right = i + len[i];
                center = i;
            }
            index = len[i] > maxlen ? i : index;
            maxlen = Math.max(maxlen, len[i]);
        }
        return str.substring(index - maxlen + 1, index + maxlen).replace("#","");
    }
}
