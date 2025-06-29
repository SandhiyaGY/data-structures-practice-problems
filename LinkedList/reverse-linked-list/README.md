<!DOCTYPE html>
<html lang="en">
<body>

  <h1><a href="https://leetcode.com/problems/reverse-linked-list" target="_blank">206. Reverse Linked List</a></h1>

  <h2>Description</h2>

  <!-- description:start -->
  <p>Given the head of a singly linked list, reverse the list, and return the reversed list.</p>

  <h3>Example 1:</h3>
  <img src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" alt="Example1" style="width:500px heigth:50px">
  <pre><code>Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]</code></pre>

  <h3>Example 2:</h3>
  <img src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" alt="Example2" style="width:100px heigth:50px">
  <pre><code>Input: head = [1,2]
Output: [2,1]</code></pre>

  <h3>Example 3:</h3>
  <pre><code>Input: head = []
Output: []</code></pre>

  <h3>Constraints:</h3>
  <ul>
    <li>The number of nodes in the list is in the range <code>[0, 5000]</code>.</li>
    <li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
  </ul>
  <!-- description:end -->

  <h2>Solutions</h2>

  <h3>Approach: Iterative Pointer Reversal</h3>
  <p>This approach iteratively reverses the linked list using three pointers:</p>
  <ul>
    <li><code>p</code>: current node</li>
    <li><code>q</code>: previous node</li>
    <li><code>r</code>: temporary pointer to store previous of <code>q</code></li>
  </ul>
  <p>We traverse the list and reverse the <code>next</code> links, finally returning the new head (<code>q</code>).</p>

  <h4>Java</h4>

  <pre><code>/**
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        ListNode q = null;
        ListNode r = null;

        while (p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }

        return q;
    }
}
</code></pre>

</body>
</html>
