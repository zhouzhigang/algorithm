# Remove Duplicate Nodes from unsorted Linked List

Write code to remove duplicates from an unsorted linked list.

FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?

## Analysis

Using hash map to check if duplicate.

If a tempoary buffer is not allowed, then we can compare from head to previous node, if exist, then stop searching and delte current node, continue next node.
