/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow is is the mid point
        ListNode mid = slow.next;
        ListNode prev = slow.next=null;
        while(mid!=null){
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        fast = head;
        while(prev!=null){
            ListNode fNext = fast.next;
            ListNode pNext = prev.next;
            fast.next = prev;
            
            prev.next = fNext;
            fast = fNext;
            prev = pNext;
        }

    }
}
