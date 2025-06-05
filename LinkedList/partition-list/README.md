

<h1><a href="https://leetcode.com/problems/partition-list">86. Partition List</a></h1>

<h2>📝 Problem Description</h2>
<p>Given the head of a linked list and a value <code>x</code>, partition it such that all nodes less than <code>x</code> come before nodes greater than or equal to <code>x</code>. You should preserve the original relative order of the nodes in each of the two partitions.</p>

<hr>

<h2>📥 Input and 📤 Output</h2>

<h3>Example 1</h3>
<img src="https://assets.leetcode.com/uploads/2021/01/04/partition.jpg" alt="Partition List Example 1">
<pre><code>Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
</code></pre>

<h3>Example 2</h3>
<pre><code>Input: head = [2,1], x = 2
Output: [1,2]
</code></pre>

<hr>

<h2>📚 Constraints</h2>
<ul>
  <li>The number of nodes in the list is in the range <code>[0, 200]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
  <li><code>-200 &lt;= x &lt;= 200</code></li>
</ul>

<hr>

<h2>💡 Approach: Two Dummy Lists to Preserve Order</h2>

<h3>🔄 Intuition:</h3>
<p>Use two dummy linked lists to separate nodes into two partitions:</p>
<ul>
  <li>Left partition: nodes with values less than <code>x</code>.</li>
  <li>Right partition: nodes with values greater than or equal to <code>x</code>.</li>
</ul>
<p>Traverse the list once, appending nodes to the appropriate partition while preserving their original relative order. Then, connect the end of the left partition to the start of the right partition.</p>

<h3>🧱 Steps:</h3>
<ol>
  <li>Create two dummy nodes: one for the left partition, one for the right.</li>
  <li>Use two pointers, <code>left</code> and <code>right</code>, starting at the dummy nodes.</li>
  <li>Traverse the original list:
    <ul>
      <li>If node value &lt; x, append it to the left list.</li>
      <li>Else, append it to the right list.</li>
    </ul>
  </li>
  <li>After traversal, set <code>right.next</code> to <code>null</code> to terminate the right list.</li>
  <li>Connect <code>left.next</code> to the head of the right partition.</li>
  <li>Return <code>leftdummy.next</code> as the new head of the partitioned list.</li>
</ol>

<hr>

<h2>✅ Java Code</h2>
<pre><code>
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
    public ListNode partition(ListNode head, int x) {
        ListNode leftdummy = new ListNode(0);
        ListNode rightdummy = new ListNode(0);
        ListNode left = leftdummy;
        ListNode right = rightdummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        right.next = null;           // Terminate right partition
        left.next = rightdummy.next; // Connect left and right partitions

        return leftdummy.next;       // Head of new partitioned list
    }
}
</code></pre>

<hr>

<h2>⏱️ Complexity Analysis</h2>
<ul>
  <li><strong>Time Complexity</strong>: <code>O(n)</code> – Single pass through the list.</li>
  <li><strong>Space Complexity</strong>: <code>O(1)</code> – No extra space except pointers.</li>
</ul>

<hr>

<h2>✅ Key Takeaways</h2>
<ul>
  <li>Using dummy nodes simplifies handling edge cases.</li>
  <li>Maintaining two separate lists preserves relative order.</li>
  <li>Connecting partitions efficiently concatenates the result.</li>
</ul>

</body>
</html>



