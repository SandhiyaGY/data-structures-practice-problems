# [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)

## Description

<!-- description:start -->

<p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<!-- description:end -->

---

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

### Approach: Two Pointers (Fast and Slow)

To remove the nth node from the end, we can use the two-pointer technique:

1. Create a dummy node pointing to the head (to simplify edge cases like removing the first node).
2. Move the fast pointer `n+1` steps ahead.
3. Then move both `fast` and `slow` pointers one step at a time until `fast` reaches the end.
4. `slow` will be right before the node to be deleted.
5. Adjust `slow.next` to skip the target node.

This approach ensures a single pass through the list with `O(n)` time complexity and `O(1)` space.

---

### Java

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
        // Create a dummy node pointing to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast ahead by n + 1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move fast to the end, maintaining the gap
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
