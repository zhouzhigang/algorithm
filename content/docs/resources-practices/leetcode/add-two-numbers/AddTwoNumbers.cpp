#include <stddef.h> // NULL
#include <stdio.h>  // printf

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    // cpp allow constructor in struct
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode head(0); // extra head node
        ListNode *curr = &head; // pointer to move next(shoud use & to get the address of head!!)
        int sum = 0;
        while (l1 != NULL && l2 != NULL) { // NULL, not null
            sum = sum / 10 + l1->val + l2->val; // which is of pointer type ‘ListNode*’ (maybe you meant to use ‘->’ ?)
            curr->next = new ListNode(sum % 10);
            curr = curr->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        // handle the rest
        ListNode *rest = l1 != NULL ? l1 : l2;
        while (rest != NULL) {
            sum = sum / 10 + rest->val;
            curr->next = new ListNode(sum % 10);
            curr = curr->next;
            rest = rest->next;
        }
        // handle the carry
        printf("carry: %d\n", sum / 10);
        if (sum / 10 != 0) {
            curr->next = new ListNode(1);
        }
        return head.next;
    }

    ListNode* addTwoNumbers2(ListNode* l1, ListNode* l2) {
        ListNode *head = NULL;
        ListNode **curr = &head; // use secondary pointer
        int sum = 0;
        while (l1 != NULL || l2 != NULL) { // NULL, not null
            sum /= 10; // add the carry first
            if (l1 != NULL) {
                sum += l1->val;
                l1 = l1->next;
            }
            if (l2 != NULL) {
                sum += l2->val;
                l2 = l2->next;
            }
            *curr = new ListNode(sum % 10);
            curr = &((*curr)->next);
        }
        // check if has carry after all finished
        if (sum / 10 != 0) {
            *curr = new ListNode(1);
        }
        return head;
    }

    ListNode* createList(int arr[], int len) {
        // int len = sizeof(arr) / sizeof(int) + 1; // wrong, arrary should specify length
        printf("length: %d\n", len);
        ListNode head(0);
        ListNode *curr = &head;
        for (int i = 0; i < len; i++) {
            curr->next = new ListNode(arr[i]);
            curr = curr->next;
        }
        return head.next;
    }
    void printList(ListNode* list) {
        while(list != NULL) {
            printf("%d->", list->val);
            list = list->next;
        }
        printf("null\n");
    }
};
int main() {
    Solution sol;
    int arr1[] = {1, 2, 3};
    int arr2[] = {4, 5, 7};
    ListNode* l1 = sol.createList(arr1, 3);
    ListNode* l2 = sol.createList(arr2, 3);
    ListNode* l3 = sol.addTwoNumbers(l1, l2);
    sol.printList(l1);
    sol.printList(l2);
    sol.printList(l3);
    return 0;
}
