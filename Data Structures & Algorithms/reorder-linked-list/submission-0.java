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
        
        //find the mid

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        //reverse the other half;
        ListNode nextNode = mid;
        ListNode prevNode = null;
        slow.next = null;
        while(nextNode != null) {
            //we need to reverse connection 4->5->6
            //we are at 5 is next 4 is prev new next is 6 new prev is 6 
            ListNode tempNode = nextNode.next;
            nextNode.next = prevNode;
            prevNode = nextNode;
            nextNode = tempNode;
        }
        //prevNode.next=null;

        ListNode first = head;
        ListNode second = prevNode;

        while(second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next=second;
            second.next=t1;
            first = t1;
            second = t2;
        }

        /* ListNode currentNode = head;

        while(currentNode!=null) {
            System.out.print(" "+currentNode.val+" -> ");
            currentNode = currentNode.next;
        }*/  
    }
}