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
    int minDiff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return minDiff;
    }

    public void helper(TreeNode node){
        if(node==null) return;
        helper(node.left);
        if(prev!=null)
        minDiff=Math.min(minDiff,Math.abs(prev-node.val));
        prev=node.val;
        helper(node.right);
    }
}