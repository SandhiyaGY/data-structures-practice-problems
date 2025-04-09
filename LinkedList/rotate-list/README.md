<!-- Problem Title -->
# [61. Rotate List](https://leetcode.com/problems/rotate-list)

## Description

<!-- description:start -->

<p>Given the head of a linked list, rotate the list to the right by <code>k</code> places.</p>

<!-- description:end -->

---

## Examples

### Example 1:
<img alt="rotate-example1" src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" style="width: 500px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], k = 2
<strong>Output:</strong> [4,5,1,2,3]
</pre>

### Example 2:
<img alt="rotate-example2" src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" style="width: 400px;" />
<pre>
<strong>Input:</strong> head = [0,1,2], k = 4
<strong>Output:</strong> [2,0,1]
</pre>

---

## Constraints

<ul>
  <li>The number of nodes in the list is in the range <code>[0, 500]</code>.</li>
  <li><code>-100 <= Node.val <= 100</code></li>
  <li><code>0 <= k <= 2 * 10⁹</code></li>
</ul>

---

## Solution

### Approach: Repeated Rotation by Moving Tail to Head

This solution uses a helper method called <code>makeHead()</code> that rotates the list one place to the right.

<ul>
  <li>Find the last node and the node before it (second last).</li>
  <li>Set <code>lastNode.next = head</code>.</li>
  <li>Make <code>lastNode</code> the new <code>head</code>.</li>
  <li>Break the old link by setting <code>prev.next = null</code>.</li>
</ul>

We repeat this process <code>k % length</code> times.

---

## Java 

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

    // Rotates the list one place to the right
    public ListNode makeHead(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null && temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        temp.next = head;
        head = temp;
        prev.next = null;

        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        k = k % count;
        while (k != 0) {
            head = makeHead(head);
            k--;
        }
        return head;
    }
}
