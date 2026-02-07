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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLength=inorder.length;
        int postLength=postorder.length;
        for(int i=0;i<inLength;i++){
            mp.put(inorder[i],i);
        }

        int inStart=0;
        int inEnd=inLength-1;
        int postStart=0;
        int postEnd=postLength-1;

        return helper(inorder,inStart,inEnd,postorder,postStart,postEnd);
    }

    public TreeNode helper(
        int[] inorder,int inStart,int inEnd,
        int[] postorder,int postStart,int postEnd
    ){
        if(inEnd<inStart||postEnd<postStart) return null;

        int nodeValue=postorder[postEnd];
        TreeNode node = new TreeNode(nodeValue);

        int inIdx=mp.get(nodeValue);
        int length=inIdx-inStart;

        node.left=helper(inorder,inStart,inIdx-1,
                            postorder,postStart,postStart+length-1);
        node.right=helper(inorder,inIdx+1,inEnd,
                            postorder,postStart+length,postEnd-1);
                            return node;
    }
}