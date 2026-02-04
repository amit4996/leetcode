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
    int totalSum=0;
    public int sumNumbers(TreeNode root) {
        int currentSum=0;
        helper(root,currentSum);
        return totalSum;
    }

    public void helper(TreeNode node,int currentSum){
        if(node==null) return;
        currentSum=currentSum*10+node.val;
        if(node.left==null && node.right==null){
            totalSum+=currentSum;
        }
        helper(node.left,currentSum);
        helper(node.right,currentSum);
    }
}