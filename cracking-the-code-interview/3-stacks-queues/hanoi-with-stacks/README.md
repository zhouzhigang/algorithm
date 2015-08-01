# Hanoi with Stacks

In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which can slide onto any tower. 
The puzzle starts with disks sorted in ascending order of size from top to bottom (e g , each disk sits on top of an even larger one).

You have the following constraints: 
(A) Only one disk can be moved at a time 
(B) A disk is slid off the top of one rod onto the next rod  
(C) A disk can only be placed on top of a larger disk 

Write a program to move the disks from the first rod to the last using Stacks 


## Analysis

First, let's think about how to solve the problem with recursive.
Suppose the tower named 'A', 'B', 'C'.

    recursive do the following steps until N equals to 1.
    Move N-1 from 'A' to 'B'
    Move Nth from 'A' to 'C'
    Move N-1 from 'B' to 'C'

Then consider about use stack to simulate recursive.

Which elements should we use stacks?
Functions or towers(StackA, StackB, StackC)?

Let's expand the recursive process, take 3 for example

    h(3, a, b, c)
        h(2, a, c, b)
            h(1, a, b, c)
                // move 1 from a to c
            // move 2 from a to b
            h(1, c, a, b)
                // move 1 from c to b
        // <<<< end of the h(2, a, c, b)
        // move 3 from a to c
        h(2, b, a, c)
            h(1, b, c, a)
                // move 1 from b to a
            move 2 from b to c
            h(1, a, b, c)
                // move 1 from a to c
        // <<<< end of the h(2, b, a, c)
    // <<<< end of h(3, a, b, c)

