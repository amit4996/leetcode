class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.offer(new Pair(root, 0L));

        while (!q.isEmpty()) {
            int size = q.size();
            long minIndex = q.peek().getValue();
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> temp = q.poll();
                TreeNode curr = temp.getKey();
                long index = temp.getValue();

                long virtualIndex = index - minIndex;

                if (i == 0) first = virtualIndex;
                if (i == size - 1) last = virtualIndex;

                if (curr.left != null) {
                    q.offer(new Pair(curr.left, 2 * virtualIndex + 1));
                }
                if (curr.right != null) {
                    q.offer(new Pair(curr.right, 2 * virtualIndex + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }
}
