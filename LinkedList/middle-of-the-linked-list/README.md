# [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list)

## Description

<!-- description:start -->

<p>Given the <code>head</code> of a singly linked list, return <strong>the middle node</strong> of the linked list.</p>

<p>If there are two middle nodes, return <strong>the second middle node</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 600px; height: auto;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [3,4,5]
<strong>Explanation:</strong> The middle node of the list is node 3.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 800px; height: auto;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5,6]
<strong>Output:</strong> [4,5,6]
<strong>Explanation:</strong> Since the list has two middle nodes with values 3 and 4, we return the second one.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>
<ul>
  <li>The number of nodes in the list is in the range <code>[1, 100]</code>.</li>
  <li><code>1 &lt;= Node.val &lt;= 100</code></li>
</ul>

<!-- description:end -->

---

## Solutions

### Approach: Fast and Slow Pointer (Tortoise Method)

This approach uses two pointers:
- `slow` advances one step at a time.
- `fast` advances two steps at a time.
- When `fast` reaches the end, `slow` will be at the middle.

If the number of nodes is even, `slow` ends up pointing to the second middle node — as required.

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
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
