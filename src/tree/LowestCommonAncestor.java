package tree;

import java.util.*;

/**
 * @author chenglee
 * @date 2020/5/3 11:03
 * @description：最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor11(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor11(root.left, p, q);
        TreeNode right = lowestCommonAncestor11(root.right, p, q);
        //如果左右两边都有返回，根节点就是最近公共祖先
        if(left != null && right != null) return root;
        //哪边返回，就是两个节点都在哪边
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor12(TreeNode root, TreeNode p, TreeNode q) {

        // 记录父节点
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        // 记录 p 和 q 的祖先节点
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        parent.put(root, null);
        queue.add(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            root = queue.poll();
            if (root.left != null) {
                parent.put(root.left, root);
                queue.add(root.left);
            }
            if (root.right != null) {
                parent.put(root.right, root);
                queue.add(root.right);
            }
        }
        while (p != null) {
            list.add(p);
            p = parent.get(p);
        }
        while (!list.contains(q))
            q = parent.get(q);
        return q;
    }

    /**
     * for binary search tree
     */
    public TreeNode lowestCommonAncestor21(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor21(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor21(root.right, p, q);
        }else{
            return root;
        }
    }
    public TreeNode lowestCommonAncestor22(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
    }
}
