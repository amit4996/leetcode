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
    public int pathSum(TreeNode root, int targetSum) {
         long currSum=0;
        Map<Long,Integer> mp = new HashMap<>();
        mp.put(0L,1);
        helper(root,(long)targetSum,currSum,mp);
        return count;
    }

    public  void helper(TreeNode node,long targetSum,long currSum,Map<Long,Integer> mp){
        if(node == null) return;
        currSum+=node.val;
        count+=mp.getOrDefault(currSum-targetSum,0);
        mp.put(currSum,mp.getOrDefault(currSum,0)+1);

        helper(node.left,targetSum,currSum,mp);
        helper(node.right,targetSum,currSum,mp);

        mp.put(currSum,mp.get(currSum)-1);
    }
}