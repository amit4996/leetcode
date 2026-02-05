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
    Integer prev=null;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode node){
        if(node==null) return true;
        boolean left = helper(node.left);
        boolean currentValid=true;
        //the reason why we can return here is that it will make prev inconsistent as 
        //it will not get updated for right recursion
        if(prev!=null && prev>=node.val) currentValid= false;
        prev=node.val;
        boolean right =helper(node.right);
        return currentValid&&left&&right;
    }
}