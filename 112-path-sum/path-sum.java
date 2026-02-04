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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int currSum=0;
        return helper(root,targetSum,currSum);
    }

    public boolean helper(TreeNode node,int targetSum,int currSum){
        if(node==null) return false;
        currSum+=node.val;
        if(node.left==null && node.right==null && currSum==targetSum) return true;
        return helper(node.left,targetSum,currSum)||helper(node.right,targetSum,currSum);
    }
}