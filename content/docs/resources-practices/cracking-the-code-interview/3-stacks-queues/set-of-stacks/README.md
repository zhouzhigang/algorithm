---
title: "Set of Stacks"
date: 2015-07-31
weight: 3
description: >
  Set of Stacks
---

Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
Implement a data structure SetOfStacks that mimics this.

SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
SetOfStacks push() and SetOfStacks pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack) 

FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack 

## Aanalysis

Implement a Stack with push, pop, isEmpty, isFull function first.
then use an ArrayList to store these Stacks.

Get the last Stack from the List first when perform push and pop.
Add a new stack in the List when perform `push` and the last stack is full.
Remove the stack from the List when perform `pop` and the last stack is empty.

What does the `popAt(int index)` mean? If we just simply pop element from this stack, it will damage the origin `pop` function.
Therefore, we need move the bottom element in next stack to current stack, and the next stack also need a whole shift, and so on.

+ [SetOfStacks.java](SetOfStacks.java)