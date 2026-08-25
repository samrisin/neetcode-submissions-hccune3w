/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    Map<Integer,Node> map = new HashMap<>();
    public Node connect(Node root) {
        dfs(root,0);
        return root;
    }

    public void dfs(Node root, int depth){
        if(root==null) return;
        if(!map.containsKey(depth)){
            map.put(depth,root);
        }else{
            map.get(depth).next = root;
            map.put(depth,root);
        }

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}