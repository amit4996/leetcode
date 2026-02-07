# Binary Tree Notes (More)

**Binary Tree Postorder Traversal (145)**
- Recursive postorder: left, right, then node; collect values in list.
- Time: O(n)
- Space: O(h) recursion + O(n) output

**Invert Binary Tree (226)**
- DFS, recurse on children then swap left and right at each node.
- Time: O(n)
- Space: O(h)

**Diameter of Binary Tree (543)**
- DFS returns height; at each node update global diameter with `leftHeight + rightHeight`.
- Return `1 + max(leftHeight, rightHeight)` to parent.
- Time: O(n)
- Space: O(h)

**Delete Nodes and Return Forest (1207)**
- Build a `Set` of values to delete; DFS returns the possibly-null subtree root.
- If parent was deleted and current isn’t, add current to result list.
- Recurse with `isParentDeleted = currentDeleted`; return null if deleted else node.
- Time: O(n)
- Space: O(n) for set + O(h) recursion

**Lowest Common Ancestor of a Binary Tree (236)**
- Base: if current is null or equals `p` or `q`, return it.
- Recurse left/right; if both return non-null, current is LCA; else return the non-null side.
- Time: O(n)
- Space: O(h)

**Find Duplicate Subtrees (652)**
- Serialize subtree as `val,left,right` with `#` for nulls; store counts in a map.
- When a serialization count hits 2, add that node to results (only once per duplicate).
- Time: O(n) nodes, but serialization costs can make it O(n^2) in worst cases.
- Space: O(n) for map + O(h) recursion

**Flatten Binary Tree to Linked List (114)**
- Postorder flatten left/right; if both exist, move left to right and append old right to the tail.
- If only left exists, move it to right and null left.
- Time: O(n) average; worst-case O(n^2) due to tail traversal each node
- Space: O(h) recursion

**Distribute Coins in Binary Tree (1021)**
- Postorder returns balance = coins in subtree - nodes in subtree.
- Add `abs(leftBalance) + abs(rightBalance)` to moves; return `balance - 1` to parent.
- Time: O(n)
- Space: O(h)

**Binary Tree Maximum Path Sum (124)**
- Postorder compute max gain from left/right; clamp negatives to 0.
- Update global with `node.val + leftGain + rightGain` (best path through node).
- Return `node.val + max(leftGain, rightGain)` to parent.
- Time: O(n)
- Space: O(h)

Legend: n = nodes, h = height.
