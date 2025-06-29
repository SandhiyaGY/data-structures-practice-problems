<!DOCTYPE html>
<html lang="en">
<body>

  <h1><a href="https://leetcode.com/problems/sort-list" target="_blank">148. Sort List</a></h1>

  <h2>Description</h2>

  <!-- description:start -->
  <p>Given the head of a linked list, return the list after sorting it in ascending order.</p>

  <h3>Example 1:</h3>
  <img src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg" alt="Example1" style="width:550px">
  <pre><code>Input: head = [4,2,1,3]
Output: [1,2,3,4]</code></pre>

  <h3>Example 2:</h3>
   <img src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg" alt="Example2" style="width:700px">
  <pre><code>Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]</code></pre>

  <h3>Example 3:</h3>
  <pre><code>Input: head = []
Output: []</code></pre>

  <h3>Constraints:</h3>
  <ul>
    <li>The number of nodes in the list is in the range <code>[0, 5 * 10^4]</code>.</li>
    <li><code>-10^5 &lt;= Node.val &lt;= 10^5</code></li>
  </ul>
  <!-- description:end -->

  <h2>Solution</h2>

  <h3>Approach: Merge Sort on Linked List</h3>
  <p>This approach uses the Merge Sort algorithm which is efficient for linked lists:</p>
  <ul>
    <li>Recursively split the list into two halves using fast and slow pointers.</li>
    <li>Sort each half recursively.</li>
    <li>Merge the two sorted halves.</li>
  </ul>
  <p>Time complexity is <code>O(n log n)</code>, and space complexity is <code>O(log n)</code> due to recursion stack.</p>

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Step 2: Merge the sorted halves
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
</code></pre>

</body>
</html>
