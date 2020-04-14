package string;

/*
* 判断两个字符串是否为旋转词
* 把字符串str的前面的任意部分挪到后面形成的字符串叫做str的旋转词，如str=“12345”，则旋转词有23451,34512,......
*/
public class IsRotation {
    public boolean isRotation(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        str1 += str1;
        if(str1.contains(str2)) return true;
        return false;
    }
}
