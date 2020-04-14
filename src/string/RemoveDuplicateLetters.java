package string;

/*
* 删除多余字符得到字典序最小的字符串
*/
//TODO:问题是啥意思？
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String str){
        return "";
    }
}
//
//    string removeDuplicateLetters(string s) {
//        if (s.empty() || s.size() == 1) return s;
//        string res = "";
//        vector<int> dict(256, 0);
//        vector<bool> visited(256, false);
//        for (int i = 0; i < s.size(); i++) dict[s[i]]++;
//        for (int i = 0; i < s.size(); i++) {
//            dict[s[i]]--;
//            if (visited[s[i]]) continue;
//            while (!res.empty() && s[i] < res.back() && dict[res.back()]) {
//                visited[res.back()] = false;
//                res.pop_back();
//            }
//            res += s[i];
//            visited[s[i]] = true;
//        }
//        return res;
//    }