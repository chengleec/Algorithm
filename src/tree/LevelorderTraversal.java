package tree;

import java.util.*;
/*
* 层次遍历,将每层分别数据保存到list中
* */
public class LevelorderTraversal {
    public List<List<Integer>> levelorderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()){
            // 队列 q 大小随时在变，因此在遍历前必须确定队列中的元素个数
            int cnt = q.size();
            for (int i = 0; i < cnt; i++){
                root = q.poll();
                list.add(root.val);
                if (root.left != null) q.offer(root.left);
                if (root.right != null) q.offer(root.right);
            }
            res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }
}
