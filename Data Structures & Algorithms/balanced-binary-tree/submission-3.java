/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0]==1;
    }

    public int[] dfs(TreeNode root){
        if(root==null) return new int[]{1,0};

        int[] lh = dfs(root.left);
        int[] rh = dfs(root.right);

       boolean balanced = (lh[0]==1 && rh[0]==1 && (Math.abs(lh[1]-rh[1])<=1));

       int height = 1+ Math.max(lh[1],rh[1]);

       return new int[]{balanced?1:0,height};

    }
}
