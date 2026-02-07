# Binary Tree Notes (More)

**Binary Tree Preorder Traversal (144)**
- Recursive: visit node, then left, then right; collect in list.
- Iterative stack: push root; pop, visit; push right then left so left is processed first.
- Morris: thread predecessors; if no left, visit and go right; else link predecessor.right to current, visit, go left; when link seen again, remove and go right.
- Time: O(n) for all.
- Space: O(h) recursion; O(h) stack; O(1) extra for Morris (excluding output).

**Same Tree (100)**
- DFS compare nodes pairwise.
- Base cases: both null => true; one null => false; vals differ => false.
- Recurse on left and right and AND results.
- Time: O(n)
- Space: O(h)

**Symmetric Tree (101)**
- DFS mirror check between left and right subtrees.
- Base: both null => true; one null or val diff => false.
- Recurse left.left vs right.right and left.right vs right.left.
- Time: O(n)
- Space: O(h)

**Binary Tree Paths (257)**
- DFS with a `path` string carried down.
- Append current value; if leaf, add to result; else append `->` and recurse.
- Time: O(n + total path length)
- Space: O(h) recursion + output

**Convert Sorted Array to BST (108)**
- Divide and conquer: choose mid as root, build left from left half, right from right half.
- Guarantees height-balanced due to mid split.
- Time: O(n)
- Space: O(h) recursion (O(log n) for balanced)

**Count Complete Tree Nodes (222)**
- Approach 1 (commented): full traversal count.
- Time: O(n)
- Space: O(h)
- Approach 2: compute leftmost height and rightmost height.
- If equal, tree is perfect => nodes = 2^(h+1)-1.
- Else recurse on left and right and add 1.
- Time: O(log^2 n) in complete tree
- Space: O(h)

**Path Sum III (437)**
- Prefix-sum DFS with hashmap: `mp[sum]` = count of prefix sums on path.
- At node, `currSum += val`; add `mp[currSum - target]` to answer.
- Increment `mp[currSum]`, recurse, then decrement on backtrack.
- Time: O(n)
- Space: O(h) recursion + O(n) hashmap worst-case

**Maximum Difference Between Node and Ancestor (1092)**
- DFS tracking current min and max along root-to-node path.
- Update global max with `currentMax - currentMin` at each node.
- Time: O(n)
- Space: O(h)

**Construct Binary Tree from Preorder and Inorder (105)**
- Preorder: first element is root.
- Use hashmap from inorder value -> index to split left/right.
- Left subtree size = inIdx - inStart; recurse with preorder ranges accordingly.
- Time: O(n)
- Space: O(n) map + O(h) recursion

**Construct Binary Tree from Inorder and Postorder (106)**
- Postorder: last element is root.
- Use inorder index to split; left size = inIdx - inStart.
- Build left from postStart..postStart+leftSize-1, right from postStart+leftSize..postEnd-1.
- Time: O(n)
- Space: O(n) map + O(h) recursion

**Serialize and Deserialize Binary Tree (297)**
- Serialize: preorder with null marker `#`, join with commas.
- Deserialize: split tokens, use index pointer; `#` => null; else node then build left/right recursively.
- Time: O(n)
- Space: O(n) tokens + O(h) recursion

Legend: n = nodes, h = height.
