package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public void recursivePostOrderTraversal(TreeNode root){
        if(root == null) return;
        recursivePostOrderTraversal(root.left);
        recursivePostOrderTraversal(root.right);

    }
    //TODO 非递归后续遍历
    public List<Integer> nonRecursivePostOrderTraversal(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        return list;
    }
}
