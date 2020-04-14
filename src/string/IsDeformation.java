package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 判断两个字符串是否为变形词
* 如果str1和str2中出现的字符种类一样且每种字符出现的次数一样，那么str1和str2互为变形词
*/
public class IsDeformation {
    public boolean isDeformation(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        int[] hash = new int[128];
        for(int i=0;i<str1.length();i++){
            hash[str1.charAt(i)]++;
        }
        for(int i=0;i<str2.length();i++){
            if(hash[str2.charAt(i)] == 0) return false;
            else hash[str2.charAt(i)] --;
        }
        return true;
    }
}
