package tree;
/*
* 利用先序遍历和中序遍历重建二叉树
*/
public class ReConstructBinaryTree {
    public TreeNode build(int[] preorder, int[] inorder, int start, int end, int index){
        if(index > preorder.length-1 || start > end) return null;
        TreeNode root = new TreeNode(preorder[index]);
        int pos = 0;
        for(int i=start;i<=end;i++){
            if(inorder[i] == root.val){
                pos = i;
                break;
            }
        }
        root.left = build(preorder,inorder,start,pos-1,index+1);
        root.right = build(preorder,inorder,pos+1,end,index+pos-start+1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return build(preorder,inorder,0,inorder.length-1,0);
    }
}
