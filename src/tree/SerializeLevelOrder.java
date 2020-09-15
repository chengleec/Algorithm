package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeLevelOrder {
    /*
    序列化;
    1、设序列后的结果字符串为str，初始时str = ""。
    2、层次遍历整颗二叉树。若结点为空，就在str结尾加上"#!"，否则(假设结点值为3)，在str结尾加上"3!"，并且结点入队，直到队列为空。
    */
    public String serialize(TreeNode root){
        if(root == null) return "";
        String res = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) res += "#!";
            else{
                res += node.val + "!";
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return res;
    }
    /*
    反序列化
    1、将序列化结果分解，结果存储到String数组中。
    2、遍历数组，设index为vector下标，初值为0，将第一个元素入队，队不空时循环。
    3、序列化时需要将结点左右子树同时入队，因此重建树时一次也要从数组中提取两个值，
    4、若第一个值为"#"，则结点左子树为NULL，若第二个结点的值为3，则新建值为3的结点为其右子树，并将非空结点入队。
    */
    public TreeNode reSerialize(String str){
        if(str == "") return null;

        String[] strs = str.split("!");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for(int i=1;i<strs.length;i++){
            TreeNode node = q.poll();
            if(!strs[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                node.left = left;
                q.offer(left);
            }
            if(!strs[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
                node.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}
