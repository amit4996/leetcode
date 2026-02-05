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
    int globalCount;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        globalCount=k;
        helper(root);
        return ans;
    }

    public void helper(TreeNode node){
        if(node == null) return;
        helper(node.left);

        if(globalCount ==0) return;

        globalCount--;
        if(globalCount==0) {ans=node.val; return;};
        helper(node.right);
    }

}