package string;

/*
* 给丁一个字符串，将单词顺序进行反转
* 例：dog loves pig => pig loves dog
*/

public class RotateWord {
    public String rotateWord(String str){
        String res = "";
        String[] words = str.trim().split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            res += words[i];
            if(i != 0) res += " ";
        }
        return res;
    }
}