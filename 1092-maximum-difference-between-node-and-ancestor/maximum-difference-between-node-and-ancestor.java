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
    int globalMax=0;
    public int maxAncestorDiff(TreeNode root) {
        int currentMaxSoFar=Integer.MIN_VALUE;
        int currentMinSoFar=Integer.MAX_VALUE;
        helper(root,currentMaxSoFar,currentMinSoFar);
        return globalMax;
    }

    public void helper(TreeNode node,int currentMaxSoFar,int currentMinSoFar){
        if(node==null) return;

        currentMaxSoFar=Math.max(currentMaxSoFar,node.val);
        currentMinSoFar=Math.min(currentMinSoFar,node.val);
        
        globalMax=Math.max(globalMax,currentMaxSoFar-currentMinSoFar);

        helper(node.left,currentMaxSoFar,currentMinSoFar);
        helper(node.right,currentMaxSoFar,currentMinSoFar);
        
    }
}