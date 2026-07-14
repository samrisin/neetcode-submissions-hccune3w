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
    HashMap<Integer,Integer> map;
    int preInd = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int left, int right){
        if(left>right) return null;
        int root_val = preorder[preInd++];
        TreeNode root = new TreeNode(root_val);
        int ind = map.get(root_val);
       root.left= build(preorder,inorder,left,ind-1);
       root.right = build(preorder,inorder,ind+1,right);

       return root;

    }
}
