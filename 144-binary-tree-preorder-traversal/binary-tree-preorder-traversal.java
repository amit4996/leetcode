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
    //recursive way
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     preOrderHelper(root,result);
    //     return result;
    // }

    // public void preOrderHelper(TreeNode node,List<Integer> result){
    //     if(node == null) return;
    //     result.add(node.val);
    //     if(node.left!=null) preOrderHelper(node.left,result);
    //     if(node.right!=null) preOrderHelper(node.right,result);
    // }

    //Iterative way
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);
        }

        return result;
    }
}