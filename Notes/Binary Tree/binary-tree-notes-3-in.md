# Binary Tree Notes (BST/Traversal)

**Binary Tree Inorder Traversal (94)**
- Recursive inorder: traverse left, visit node, traverse right; collect values in list.
- Time: O(n)
- Space: O(h) recursion + O(n) output

**Minimum Distance Between BST Nodes (799)**
- Inorder traversal gives sorted values; track `prev` and update `minDiff` with `node.val - prev`.
- Time: O(n)
- Space: O(h)

**Minimum Absolute Difference in BST (530)**
- Same inorder + `prev` pattern as above; update global minimum difference.
- Time: O(n)
- Space: O(h)

**Validate Binary Search Tree (98)**
- Inorder traversal must be strictly increasing; track `prev`, if `prev >= node.val` mark invalid.
- The code avoids early return so `prev` is updated consistently for the rest of the traversal.
- Time: O(n)
- Space: O(h)

**Kth Smallest Element in a BST (230)**
- Inorder traversal with a counter `k`; decrement when visiting a node; when it hits 0, store answer and stop exploring further.
- Time: O(n) worst-case (early stop in practice)
- Space: O(h)

**Binary Search Tree Iterator (173)**
- Stack-based inorder: constructor pushes entire left spine; `next()` pops, then pushes left spine of right child.
- `hasNext()` checks stack non-empty; amortized O(1) per `next()`.
- Time: O(1) amortized per `next()`, O(n) total
- Space: O(h)

Legend: n = nodes, h = height.
