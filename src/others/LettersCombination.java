package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/6/15 9:25
 * @description
 */
public class LettersCombination {
    public static List<String> letterCombinations(String digits) {

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < digits.length(); i++){
            String letters = map[digits.charAt(i)-'0'];
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < res.size(); j++){
                for (int k = 0; k < letters.length(); k++){
                    tmp.add(res.get(j) + letters.charAt(k));
                }
            }
            res = tmp;
        }

        return res;
    }
}
