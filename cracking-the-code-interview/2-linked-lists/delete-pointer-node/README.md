# Delete 

Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
EXAMPLE
Input: the node `‘c’` from the linked list `a->b->c->d->e`
Result: nothing is returned, but the new linked list looks like `a->b->d->e`

## Analysis

Note: the middel doesn't mean the median, it means that a pointer point to the middle of a signle linked list, and the difficulty is that we don't know the head, so that we didn't know the previous node.

    a -> b -> c -> d -> e           a -> b -> c -> e
              ^                               ^
              | current pointer               | easy to delete d, not c

Copy data in `d` to `c`, next cotinue.
