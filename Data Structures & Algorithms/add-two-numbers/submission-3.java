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
    ListNode l3 = new ListNode(-1);
    ListNode dummy = l3;
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while(l1!=null || l2!=null){
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;
            int sum = val1+val2+carry;
            dummy.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            dummy = dummy.next;

        }
        if(carry!=0){
            dummy.next= new ListNode(carry);
        }
    return l3.next;
    }
}
