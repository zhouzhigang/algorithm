# Check if a tree is balanced

Implement a function to check if a tree is balanced.

For the purposes of this question, a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.

## Analysis

**Note**: the balanced tree here is different from balanced binary tree.

Balanced binary tree means the diff between the depth of left child and right child of any node should be less than one.

While here it mean the diff between max depth and min depth is less than one.

We can get the depth by recursive get the left child depth and right child depth.
