/* 
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Definition for singly-linked list.
 * 
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Explanation: 342 + 465 = 807.
 * 
 */
#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode * root = NULL;
        ListNode * node = NULL;
        int mem = 0;
        do {
            int val = mem;
            if (l1) {
                val += l1->val;
            }
            if (l2) {
                val += l2->val;
            }
            mem = val / 10;
            val = val % 10;
            if (root == NULL) {
                root = node = new ListNode(val);
            } else {
                node->next = new ListNode(val);
                node = node->next;
            }
            if (l1) {
                l1 = l1->next;
            }
            if (l2) {
                l2 = l2->next;
            }
            if (!l1 && !l2) {
                break;
            }
        } while (true);
        
        if (mem) {
            node->next = new ListNode(mem);
        }
        return root;
    }
};

void printList(ListNode* list);

int main() {
    
    Solution s;
    
    // 2 -> 4 -> 3
    ListNode root1(2);
    ListNode n11(4);
    ListNode n12(3);
    root1.next = &n11;
    n11.next = &n12;
    
    // 5 -> 6 -> 4
    ListNode root2(5);
    ListNode n21(6);
    ListNode n22(4);
    root2.next = &n21;
    n21.next = &n22;
    
    printList(&root1);
    printList(&root2);
    
    printList(s.addTwoNumbers(&root1, &root2));
    
//     ListNode root1(5);
//     ListNode root2(5);
//     printList(s.addTwoNumbers(&root1, &root2));
    
//     ListNode root1(1);
//     ListNode n11(8);
//     root1.next = &n11;
//     ListNode root2(0);
//     printList(s.addTwoNumbers(&root1, &root2));
}
    
void printList(ListNode* list) {
    do {
        cout << list->val << " -> ";
    } while(list = list->next);
    cout << endl;
}
