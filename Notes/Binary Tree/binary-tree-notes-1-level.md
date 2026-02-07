# Binary Tree BFS/DFS Notes (LeetCode)

**Binary Tree Level Order Traversal (102)**
- BFS (queue): push root, then for each level pop `size` nodes, collect values into a level list, and enqueue children; append level list to result.
- Key idea: level boundaries come from the queue size at loop start.
- Time: O(n)
- Space: O(w) queue + O(n) output
- DFS (depth list): `helper(node, depth)` creates a new list when `depth == result.size()`, then adds node value and recurses left then right.
- Key idea: depth index acts as the level number.
- Time: O(n)
- Space: O(h) recursion + O(n) output

**Binary Tree Right Side View (199)**
- BFS: level order traversal; for each level, add the last node encountered (`i == size - 1`) to the result.
- Key idea: the last node in a level is the visible one from the right.
- Time: O(n)
- Space: O(w) queue + O(n) output
- DFS (right-first): traverse right before left; when `depth == result.size()` add the node to result.
- Key idea: first node reached at each depth is the rightmost.
- Time: O(n)
- Space: O(h) recursion + O(n) output

**Binary Tree Zigzag Level Order Traversal (103)**
- BFS + reverse: do standard level order, then reverse the list on alternate levels using a boolean flag.
- Key idea: same traversal order, flip presentation per level.
- Time: O(n)
- Space: O(w) queue + O(n) output
- BFS with deque: when left-to-right, pop from front and push children to back; when right-to-left, pop from back and push children to front in reverse order.
- Key idea: control traversal direction at dequeue/enqueue time to avoid reversing.
- Time: O(n)
- Space: O(w) deque + O(n) output

**Populating Next Right Pointers in Each Node II (117)**
- BFS: level order traversal using a queue; for each level, connect each node’s `next` to `queue.peek()` except the last, which points to `null`.
- Key idea: queue preserves left-to-right order even in non-perfect trees.
- Time: O(n)
- Space: O(w) queue

**Maximum Width of Binary Tree (662)**
- BFS with indices: store `(node, index)` where index is the node’s position in a complete binary tree; normalize each level by subtracting the first index to keep numbers small.
- For each level, width = `lastIndex - firstIndex + 1`; enqueue children with indices `2*idx+1` and `2*idx+2` using `long`.
- Key idea: virtual positions capture gaps between nodes.
- Time: O(n)
- Space: O(w) queue

Legend: n = number of nodes, h = tree height, w = max width of any level.
