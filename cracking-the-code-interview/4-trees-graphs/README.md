# Trees and Graphs

## how to Approach

Trees and grphs questions typically come in one of two forms:

1. Implement a tree / find a noe / delete a node / other well known algorithm.

2. Implement a modification of a known algorithm.

## Warning: Not all binary trees are binary search trees.

## Binary Trees - "Must Know" algorithms

* __In-Order__: Traverse left node, current node, then right[usually used for binary search trees]

* __Pre-Order__: Traverse current node, then left node, then right node.

* __Post-Order__: Traverse left node, then right node, then current node.

* __Insert Node__: On a binary search tree, we insert a value v, by comparing it to the root. If v > root, we go right, and else we go left. We do this util we hit an empty spot in the tree.

## Graph Traversal - "Must Know" Algorithms

* __Depth First Search__: DFS involves searching a node and all its children before proceeding to its siblings.

* __Breadth First Search__: BFS involves searching a node and its siblings before going on to any children.


## Exercises

|No.|Title|Solution|
|---|-----|--------|
|4.1|[Check if a tree is balanced](is-balanced-tree)|[Java](is-balanced-tree/IsBalancedTree.java)|
|4.2|[Find out wether there is a route between two nodes in a directed graph]()|[Java]()
|4.3|[Create a binary tree with minimal height with a sorted array]()|[Java]()|
|4.4|[Create a linked list of all the nodes at each depth for a binary search tree]()|[Java]()|
|4.5|[Find the next node of a given node in a binary search tree]()|[Java]()|
|4.6|[Find the first common ancestor of two nodes in a binary tree]()|[Java]()|
|4.7|[Decide if T2 is a subtree of T1(binary trees)]()|[Java]()|
|4.8|[Print all paths which sum up to a value]()|[Java]()|

