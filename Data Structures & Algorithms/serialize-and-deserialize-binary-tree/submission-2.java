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

public class Codec {

    // Encodes a tree to a single string.
    StringBuilder treeString = new StringBuilder();
        int ind[] = {0};
    public String serialize(TreeNode root) {
        dfs(root);
        return treeString.toString();
    }
    public void dfs(TreeNode root){
            if(root==null){
            treeString.append("# ");
            return;
        }
        treeString.append(root.val+" ");
        serialize(root.left);
        serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] treeData = data.split(" ");
    
        if(treeData[0].equals("#")) return null;
       // TreeNode root = new TreeNode(Integer.valueOf(data[0]));
    
        return deserializeDFS(treeData);
    }

     public TreeNode deserializeDFS(String[] treeData){
        if(treeData[ind[0]].equals("#")){
            ind[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(treeData[ind[0]]));
        ind[0]++;
        node.left = deserializeDFS(treeData);
        node.right = deserializeDFS(treeData);
        return node;
     }
}
