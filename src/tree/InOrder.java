package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
非递归方式遍历步骤：
1、将根结点入栈
2、将左边界压入栈中，即不停的令root = root.left，stack.push(root)；
3、若root为空，则从栈中弹出一个结点并访问，并令root = root.right，继续重复步骤2。
4、当栈为空并且root也为空时，循环结束。
*/
public class InOrder {
    public void recursiveInOrder(TreeNode root){
        if(root == null) return;
        recursiveInOrder(root.left);
        System.out.println(root.val);
        recursiveInOrder(root.right);
    }

    public List<Integer> nonRecursiveInorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
