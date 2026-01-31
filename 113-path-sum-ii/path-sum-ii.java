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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        helper(root,targetSum,currPath,result);
        return result;
    }

    public void helper(TreeNode curr,int targetSum,List<Integer> currPath,List<List<Integer>> result){
        if(curr==null) return ;
        currPath.add(curr.val);
        targetSum-=curr.val;
        if(targetSum==0 && curr.left==null && curr.right==null){
            result.add(new ArrayList<>(currPath));
        }
        helper(curr.left,targetSum,currPath,result);
        helper(curr.right,targetSum,currPath,result);
        currPath.remove(currPath.size() - 1);
    }
}