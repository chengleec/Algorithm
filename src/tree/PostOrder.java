package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public void recursivePostOrder(TreeNode root){
        if(root == null) return;
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);

    }
    //TODO 非递归后续遍历
    public List<Integer> nonRecursivePostOrder(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        return list;
    }
}
