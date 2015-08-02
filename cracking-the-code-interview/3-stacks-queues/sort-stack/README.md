# Sort a Stack

Write a program to sort a stack in ascending order.
You should not make any assumptions about how the stack is implemented.
The following are the only functions that should be used to write this program: `push` | `pop` | `peek` | `isEmpty`.

## Analysis

Think about tranditional sort algorithm first.
Insertion sort
    
    for (i=1; i <n; i++)
        temp = a[i]
        for (j = i; j >=0; j++)
            if (a[j] > temp)
                a[j+1] = a[j];
            else
                a[j+1] = temp

For stack, the difficulty is we can only pop and push at the top.
If we want to adjust the order, maybe we need another stack(just like [implementing a queue using two stacks](../queue-two-stacks)) and a temp variable.

    s   t       s   t       s   t       s   t       s   t       s   t
    4(temp)                                                        
    3           3(temp)     4(push back)            3               5
    5           5           5               5       4               4
    1           1           1           1   4       5               3
    2           2   4(top)  2   3       2   3       2   1       2   1


    temp = s.pop()
    // find right position of temp in stack t
    while t!=null && t.peek > temp
        push back
    // insert temp in stack t
    t.push(temp)
