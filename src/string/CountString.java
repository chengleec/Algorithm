package string;

/*
* 字符串的统计字符串
* 如str="aaab",则统计字符串为a_3_b_1
*/
public class CountString {
    public String countString(String str){
        String res = str.substring(0,1);
        int cnt = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)== str.charAt(i-1)){
                cnt ++;
            }else{
                res += "_" + cnt + "_" + str.charAt(i);
                cnt = 1;
            }
        }
        return res;
    }
}
