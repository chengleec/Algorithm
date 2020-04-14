package tree;


import java.util.Scanner;

public class SerializePreorder {
    /*
    序列化：
    1、设序列化的结果字符串为str，初始时str = ""。
    2、先序遍历二叉树，若遇到null结点，就在str的末尾加上"#!"，"#"表示这个结点为空，"!"表示一个结点的结束。
    3、若遇到不空的结点，假设结点值为3，则在str的末尾加上"3!"。
    */
    public String serialize(TreeNode root){
        if(root == null) return "#";
        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }
    /*
    反序列化：
    1、利用将序列化结果字符串str分解。
    2、遍历处理后的序列结果，若值为"#"，则返回NULL，否则新建结点。按先序遍历的顺序递归重建整棵树。
    */
    public TreeNode build(Scanner sc){
        if(!sc.hasNext()) return null;
        String str = sc.next();
        if(str.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = build(sc);
        root.right = build(sc);
        return root;
    }
    public TreeNode reSerialize(String str){
        return build(new Scanner(str).useDelimiter("!"));
    }
}
