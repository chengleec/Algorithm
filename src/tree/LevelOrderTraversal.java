package tree;

import java.util.*;
/*
* 层次遍历,将每层分别数据保存到list中
* */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int cnt = q.size();
            for(int i=0;i<cnt;i++){
                root = q.poll();
                level.add(root.val);
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            }
            res.add(level);
        }
        return res;
    }
}
