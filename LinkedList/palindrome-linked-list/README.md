# [234.Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list)

## Description

<!-- description:start -->

Given the head of a singly linked list, return `true` if it is a palindrome or `false` otherwise.

### Example 1:
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 662px; height: 100px;" />
<pre>
<strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

### Example 2:
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 300px; height: 100px;" />
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>  

<!-- description:end -->

---

## Constraints

- The number of nodes in the list is in the range `[1, 10^5]`.
- `0 <= Node.val <= 9`

---

## Solutions

### Approach: Fast and Slow Pointers + Reverse Second Half

This approach checks if a linked list is a palindrome in `O(n)` time and `O(1)` space.

- Use two pointers (fast and slow) to find the middle of the list.
- Skip the middle node if the list length is odd.
- Reverse the second half of the list.
- Compare the two halves node by node.
- Return `true` if all values match, otherwise `false`.

---

### Java
```java
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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //REVERSING THE SECOND HALF
        //If length of the LL is odd remove the first node from the left side
        //If fast pointer reach null then the length is odd
        ListNode curr=null;
        if(fast!=null){
            curr=slow.next;
        }
        curr=slow;
        ListNode prev=null;
        ListNode nextNode=null;
        while(curr!=null){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        ListNode left=head;
        ListNode right=prev;
        while(left!=null && right!=null){
            if(left.val!=right.val){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
}



