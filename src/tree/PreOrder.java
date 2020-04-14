package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
非递归遍历步骤：
1、根节点先进栈。
2、当栈不空时循环，每次弹出一个结点并访问，若结点右孩子存在，则右孩子进栈，若结点左孩子存在，则左孩子进栈
（入栈顺序为先右后左，最后访问顺序就为先左后右）。
*/
public class PreOrder {
    public void recursivePreorder(TreeNode root){
        if(root == null) return;
        System.out.println("root.val");
        recursivePreorder(root.left);
        recursivePreorder(root.right);
    }

    public List<Integer> nonRecursivePreorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            root = stack.pop();
            res.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return res;
    }
}
