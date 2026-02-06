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
    int count=0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return count;
    }

    public int helper(TreeNode node){
        if(node==null) return 0;
        int left=helper(node.left);  //positive if it sends , neg if it receives
        int right=helper(node.right); //pos if it sends , neg if it receives
        int balance=node.val+left+right;
        count+=Math.abs(left)+Math.abs(right);
        return balance-1;
    }
}