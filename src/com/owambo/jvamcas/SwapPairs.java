package com.owambo.jvamcas;

/**
 * Solution to leetcode swap pairs:
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */
class SwapPairs <K>{
     class ListNode{
        K val;
        ListNode next;
        ListNode(K val){this.val = val;}
    }
    public ListNode swapPairs(ListNode head) {

        if(head == null) return head;//if list empty
        ListNode root = head.next;
        ListNode oldHead = null;

        while(head != null){

            if(head.next == null)//cater for odd-sized linked list
                break;

            ListNode current = head.next;//2nd node from head node
            ListNode temp = current.next;//rest of the list

            head.next = null;
            current.next = head;

            if(oldHead != null)//prevent cycling at head of list
                oldHead.next = current;

            oldHead = head;
            head = temp;
        }
        return root;
    }
}
