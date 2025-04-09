# [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)

## Description

<!-- description:start -->

<p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<!-- description:end -->



## Examples

### Example 1:
<img alt="example1" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 500px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

### Example 2:
<pre>
<strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

### Example 3:
<pre>
<strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

---

## Constraints

- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

---

## Solutions

### Approach: Two-Pass Algorithm (Count Length First)

<ul>
  <li>Step 1: Traverse the entire list to calculate its length <code>len</code>.</li>
  <li>Step 2: If <code>n == len</code>, it means the node to remove is the head itself. Return <code>head.next</code>.</li>
  <li>Step 3: Traverse again to reach the node just before the one that needs to be deleted (<code>len - n</code> steps).</li>
  <li>Step 4: Remove the target node by skipping it: <code>prev.next = cur.next</code>.</li>
</ul>

---

## Java

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        if (n == len) {
            return head.next;
        }
        ListNode cur = head;
        ListNode prev = null;
        for (int i = 0; i < len - n; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;

        return head;
    }
}
