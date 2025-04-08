# [141: Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)


## Description

<!-- description:start -->

<p>Given <code>head</code>, the head of a linked list, determine if the linked list has a cycle in it.</p>

<p>There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the <code>next</code> pointer.</p>

<p>Internally, <code>pos</code> is used to denote the index of the node that the tail's <code>next</code> pointer is connected to. Note that <code>pos</code> is not passed as a parameter.</p>

<p>Return <code>true</code> if there is a cycle in the linked list. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="width: 600px; height: auto;" />

<pre>
<strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
</pre>
<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="width: 300px; height: auto;" />
<pre>
<strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 0th node.
</pre>

<p><strong class="example">Example 3:</strong></p>
<pre>
<strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no cycle in the linked list.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of the nodes in the list is in the range <code>[0, 10⁴]</code>.</li>
  <li><code>-10⁵ &lt;= Node.val &lt;= 10⁵</code></li>
  <li><code>pos</code> is <code>-1</code> or a valid index in the linked list.</li>
</ul>

<!-- description:end -->

---

## Solutions

### Approach: Floyd’s Cycle Detection Algorithm (Tortoise and Hare)

This method uses two pointers (`slow` and `fast`) that traverse the linked list at different speeds:

- `slow` moves one node at a time.
- `fast` moves two nodes at a time.
- If there is a cycle, these two pointers will eventually meet.
- If there is no cycle, the `fast` pointer will reach the end (`null`) first.

This approach is efficient and uses **O(1)** space.

---

### Java

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&& fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
        
    }
}
