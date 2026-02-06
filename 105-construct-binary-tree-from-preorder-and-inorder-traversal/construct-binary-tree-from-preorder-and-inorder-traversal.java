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
    Map<Integer,Integer> mp = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart=0;
        int preEnd=preorder.length-1;
        int inStart=0;
        int inEnd=inorder.length-1;

        for(int i=0;i<inorder.length;i++) mp.put(inorder[i],i);
        return helper(preorder,preStart,preEnd,inorder,inStart,inEnd);
    }

    public TreeNode helper(int[] preorder,int preStart,int preEnd, 
    int[] inorder,int inStart,int inEnd){
        if(preEnd<preStart || inEnd<inStart) return null;
        int nodeValue=preorder[preStart];
        TreeNode node = new TreeNode(nodeValue);

        int inIdx=mp.get(nodeValue);

        int lengthToBeSkippedInPreorder=inIdx-inStart;

        node.left=helper(preorder,preStart+1,preEnd,inorder,inStart,inIdx-1);
        node.right=helper(preorder,preStart+lengthToBeSkippedInPreorder+1,preEnd,inorder,inIdx+1,inEnd);

        return node;
    }
}