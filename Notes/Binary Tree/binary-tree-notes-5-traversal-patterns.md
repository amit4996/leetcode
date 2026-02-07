# Binary Tree Traversal Patterns (Based on Your Solutions)

## Level Order (BFS)
Use when the output is level-based or depends on left-to-right order per depth.

Signals:
- “level order”, “zigzag”, “right side view”, “next right pointer”
- “width” of tree or anything tied to level indices

Why it fits:
- A queue preserves left-to-right order and gives natural level boundaries.

Examples from your code:
- 102 Level Order: build list per level.
- 103 Zigzag: flip direction per level.
- 199 Right Side View: last node per level.
- 117 Next Right Pointers II: connect neighbors in same level.
- 662 Width: BFS with virtual indices.

## Preorder (Root ? Left ? Right)
Use when you must process or decide at the node before seeing its children.

Signals:
- “serialize/deserialize” with root-first tokens
- “construct tree from preorder”
- “root-to-leaf path” building
- “carry ancestor info down the tree”

Why it fits:
- You emit or use the root early, then recurse to children.

Examples from your code:
- 297 Serialize: preorder with null markers.
- 105 Build from preorder + inorder: root is first in preorder.
- 257 Binary Tree Paths: append root before children.
- 1092 Max ancestor diff: pass min/max downward.

## Inorder (Left ? Root ? Right)
Use when the tree is a BST and you need sorted order.

Signals:
- “BST”, “kth smallest”, “min difference”, “validate BST”

Why it fits:
- Inorder traversal of BST yields sorted values.

Examples from your code:
- 94 Inorder traversal.
- 530, 799 Min diff in BST: track `prev`.
- 98 Validate BST: ensure strictly increasing inorder.
- 230 Kth smallest: decrement k on inorder visit.
- 173 BST Iterator: stack simulates inorder.

## Postorder (Left ? Right ? Root)
Use when parent needs results from both children first (bottom-up).

Signals:
- “height/diameter/path sum”
- “balance/redistribution”
- “delete node and reconnect”
- “flatten/transform subtrees”

Why it fits:
- Child results are ready before you process the parent.

Examples from your code:
- 543 Diameter: needs left/right heights.
- 124 Max path sum: combine left/right gains.
- 1021 Distribute coins: use balances from children.
- 114 Flatten: flatten children then rewire.
- 1207 Delete nodes: decide node after children processed.
- 652 Duplicate subtrees: serialize children first.

## Quick Decision Checklist
- Output grouped by levels or neighbor links? ? Level order (BFS).
- BST ordered values or rank queries? ? Inorder.
- Root decisions or root-to-leaf paths? ? Preorder.
- Combine child results or restructure tree? ? Postorder.
