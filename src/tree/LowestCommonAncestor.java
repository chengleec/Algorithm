package tree;

/**
 * @author chenglee
 * @date 2020/5/3 11:03
 * @description：最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左右两边都有返回，根节点就是最近公共祖先
        if(left != null && right != null) return root;
        //哪边返回，就是两个节点都在哪边
        return left != null ? left : right;
    }
}
