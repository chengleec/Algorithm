package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public void recursivePostorderTraversal(TreeNode root){
        if(root == null) return;
        recursivePostorderTraversal(root.left);
        recursivePostorderTraversal(root.right);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.addFirst(root.val);
            if(root.left!=null)
                stack.push(root.left);
            if(root.right!=null)
                stack.push(root.right);
        }
        return list;
    }
}
