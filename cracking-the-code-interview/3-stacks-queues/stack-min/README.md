# Stack with push, pop. min in O(1) runtime

How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
Push, pop and min should all operate in O(1) time 

## Analysis

In general, the runtime of push and pop is O(1).
Is it possible to use an extra space to save the min element?
It's easy to know which is the min after `push`; but it's not easy to know which is the min after `pop`.

To get the min element after push, we need to know the min element in the rest stack. Therefore, we can add use more space to store the min element from current node to the stack bottom. 
