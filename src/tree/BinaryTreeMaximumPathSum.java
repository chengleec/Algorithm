package tree;

/**
 * @author chenglee
 * @date 2020/6/19 15:41
 * @description：
 *          13
 *         / \
 *        12  14
 *       / \
 *      7   2
 * 最大路径和为 7 + 12 + 13 + 14
 */
public class BinaryTreeMaximumPathSum {
    private int maxVal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxVal;
    }
    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        // 表示以 root 为根节点的树的最大路径和
        maxVal = Math.max(maxVal, left + right + root.val);
        // 返回值只能返回其中一支
        return Math.max(left, right) + root.val;
    }
}
