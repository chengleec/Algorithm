package string;

import java.util.Stack;

/**
 * @author chenglee
 * @date 2020/5/17 9:58
 * @description
 */
public class DecodeString {
    /**
     1. 没有中括号时正常运算，将结果存入res中
     2. 遇到左括号时将res及括号之前的数字分别压栈
     3. 遇到右括号时将取出左括号之前的数字（stack中取出），并加上左括号前的运算结果res（stack中取出），并拼接字符串
     */
    public static String decodeString(String s) {
        Stack<Integer> cntStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                cnt = cnt * 10 + ch - '0';
            } else if ( ch == '[') {
                cntStack.push(cnt);
                resStack.push(cur);
                cur = new StringBuilder();
                cnt = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = resStack.pop();
                for (int i = cntStack.pop(); i > 0; --i)
                    cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
    }
}
