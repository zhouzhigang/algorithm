# Implement a queue using two stacks

Implement a MyQueue class which implements a queue using two stacks 

## Analysis

Stack: LIFO(Last In First Out), push and pop on the top.
Queue: FIFO(First In First Out), add in the tail, remove in the front.

Therefore, we can use push the element in one stack; when we need remove some element from the queue, we will pop elements from tail to front, then pop the front element.


