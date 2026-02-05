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
        List<Integer> path = new ArrayList<>();
        int currentMaxSoFar=Integer.MIN_VALUE;
        int currentMinSoFar=Integer.MAX_VALUE;
        helper(root,path,currentMaxSoFar,currentMinSoFar);
        return globalMax;
    }

    public void helper(TreeNode node,List<Integer> path,int currentMaxSoFar,int currentMinSoFar){
        if(node==null) return;

        path.add(node.val);

        for(int i=0;i<path.size();i++){
            currentMaxSoFar=Math.max(currentMaxSoFar,path.get(i));
            currentMinSoFar=Math.min(currentMinSoFar,path.get(i));
        }

        globalMax=Math.max(globalMax,currentMaxSoFar-currentMinSoFar);
        helper(node.left,path,currentMaxSoFar,currentMinSoFar);
        helper(node.right,path,currentMaxSoFar,currentMinSoFar);

        path.remove(path.size()-1);
        
    }
}