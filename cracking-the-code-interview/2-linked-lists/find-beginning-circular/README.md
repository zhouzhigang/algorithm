# Find beginning node in a circular linked list

Given a circular linked list, implement an algorithm which returns node at the beginning of the loop 
DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list 

EXAMPLE
Input: `A -> B -> C -> D -> E -> C` [the same `C` as earlier]
Output: `C`

## Analysis

Two pointers
Pointer `p` step: 1
Pointer `q` step: 2

If there is a loop, then `p` and `q` will meet after `k` steps, `k` is the count of nodes in loops(also the steps in loops).

Suppose the step from `head` to `bn`(beginning of node) is `x`, then steps from `bn` to `mp`(meet point) is `k-x`(p moved `k` steps to meet point), so the steps from `mp` to `bn` is `k-(k-x)=x`.

Therefore, we can move `q` to head, and change step to 1, then `p` and `q` will meet again at the begining of node after `x` steps.

