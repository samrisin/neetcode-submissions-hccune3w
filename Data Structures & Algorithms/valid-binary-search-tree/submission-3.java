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
    public boolean isValidBST(TreeNode root) {
        return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode root, int min_val, int max_val){
        if(root==null) return true;

        if(root.val<=min_val || root.val>=max_val) return false;

        return validate(root.left,min_val,root.val) && validate(root.right,root.val,max_val);
    }
}
