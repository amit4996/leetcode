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
    int globalMax=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return globalMax;
    }
    public int helper(TreeNode node){
        if(node == null) return 0;

        int left=helper(node.left);
        left=Math.max(0,left);
        int right=helper(node.right);
        right=Math.max(0,right);

        int sum=node.val+left+right;
        if(sum>globalMax) globalMax=sum;

        return node.val+Math.max(left,right);
    }
}