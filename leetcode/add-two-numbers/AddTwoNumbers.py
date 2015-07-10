# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:

    # Add Two Numbers.
    # You are given two linked lists representing two non-negative numbers.
    # The digits are stored in reverse order and each of their nodes contain a single digit.
    # Add the two numbers and return it as a linked list.
    # Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    # Output: 7 -> 0 -> 8
    def addTwoNumbers(self, l1, l2):
        head = ListNode(0) # needn't new to create an instance
        curr = head
        sum = 0
        while l1 != None and l2 != None:
            sum = l1.val + l2.val + sum / 10
            curr.next = ListNode(sum % 10)
            l1 = l1.next
            l2 = l2.next
            curr = curr.next
        # handle the rest condition
        if l1 == None:
            rest = l2
        else:
            rest = l1
        # no carry, set the rest link as next
        if sum / 10 == 0:
            curr.next = rest
            return head.next
        # has carry
        while rest != None:
            sum = rest.val + sum / 10
            curr.next = ListNode(sum % 10)
            rest = rest.next
            curr = curr.next
        if sum / 10 == 1:
            curr.next = ListNode(1)
        return head.next

    def createList(self, arr):
        head = ListNode(0)
        curr = head
        for val in arr:
            curr.next = ListNode(val)
            curr = curr.next
        return head.next

    def printList(self, ll):
        while ll != None:
            print ll.val, " -> ", # put `,` in the end(python 2.x) to make sure it will not print '\n'
            ll = ll.next
        print "None"

if __name__ == '__main__':
    sol = Solution()
    arr1, arr2 = [2, 4, 3], [5, 6, 4]
    l1, l2 = sol.createList(arr1), sol.createList(arr2)
    sol.printList(l1)
    sol.printList(l2)
    result = sol.addTwoNumbers(l1, l2)
    sol.printList(result)
