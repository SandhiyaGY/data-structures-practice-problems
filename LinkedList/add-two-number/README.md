<!DOCTYPE html>
<html lang="en">

<body>

  <h1><a href="https://leetcode.com/problems/add-two-numbers" target="_blank">2. Add Two Numbers</a></h1>

  <h2>Description</h2>

  <!-- description:start -->
  <p>You are given two non-empty linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit.</p>

  <p>Add the two numbers and return the sum as a linked list.</p>

  <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

  <h3>Example 1:</h3>
  <img src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" alt="Example image" style="width:400px">
  <pre><code>Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807</code></pre>

  <h3>Example 2:</h3>
  <pre><code>Input: l1 = [0], l2 = [0]
Output: [0]</code></pre>

  <h3>Example 3:</h3>
  <pre><code>Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]</code></pre>

  <h3>Constraints:</h3>
  <ul>
    <li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
    <li><code>0 &lt;= Node.val &lt;= 9</code></li>
    <li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
  </ul>
  <!-- description:end -->

  <h2>Solution</h2>

  <h3>Approach: Digit-by-Digit Addition with Carry</h3>
  <p>This method simulates elementary addition digit by digit, tracking the carry.</p>
  <ul>
    <li>A dummy node is used to simplify edge handling and store the result.</li>
    <li>Loop through <code>l1</code> and <code>l2</code> simultaneously, summing corresponding digits plus any carry.</li>
    <li>If one list is longer, continue summing with carry.</li>
    <li>Finally, if a carry remains, add a new node for it.</li>
  </ul>

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            dummy.next = new ListNode(sum % 10);
            carry = sum / 10;
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            dummy.next = new ListNode(sum % 10);
            carry = sum / 10;
            dummy = dummy.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            dummy.next = new ListNode(sum % 10);
            carry = sum / 10;
            dummy = dummy.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }

        return head.next;
    }
}
</code></pre>

</body>
</html>
