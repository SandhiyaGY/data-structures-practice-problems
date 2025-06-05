<h1><a href="https://leetcode.com/problems/reverse-linked-list-ii">92. Reverse Linked List II</a></h1>

<h2>📝 Problem Description</h2>
<p>Given the head of a singly linked list and two integers <code>left</code> and <code>right</code> where <code>left &lt;= right</code>, reverse the nodes of the list from position <code>left</code> to position <code>right</code>, and return the reversed list.</p>

<hr>

<h2>📥 Input and 📤 Output</h2>

<h3>Example 1</h3>
<img src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" alt="Example 1">
<pre><code>Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
</code></pre>

<h3>Example 2</h3>
<pre><code>Input: head = [5], left = 1, right = 1
Output: [5]
</code></pre>

<hr>

<h2>📚 Constraints</h2>
<ul>
  <li>The number of nodes in the list is <code>n</code>.</li>
  <li><code>1 &lt;= n &lt;= 500</code></li>
  <li><code>-500 &lt;= Node.val &lt;= 500</code></li>
  <li><code>1 &lt;= left &lt;= right &lt;= n</code></li>
</ul>

<hr>

<h2>💡 Approach: In-Place Sublist Reversal</h2>

<h3>🔄 Intuition:</h3>
<p>To reverse a portion of a singly linked list:</p>
<ul>
  <li>Traverse to the node just before the <code>left</code>-th node.</li>
  <li>Reverse the next <code>(right - left + 1)</code> nodes.</li>
  <li>Reconnect the reversed part to the rest of the list.</li>
</ul>

<h3>🧱 Steps:</h3>
<ol>
  <li>Use a dummy node pointing to the head to simplify edge cases.</li>
  <li>Traverse to the node before the <code>left</code> position (<code>prev</code>).</li>
  <li>Reverse the sublist from position <code>left</code> to <code>right</code>.</li>
  <li>Reconnect the reversed sublist back to the list.</li>
  <li>Return the new head of the list via <code>dummy.next</code>.</li>
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}
</code></pre>

<hr>

<h2>⏱️ Complexity Analysis</h2>
<ul>
  <li><strong>Time Complexity</strong>: <code>O(n)</code> – One full pass through the list.</li>
  <li><strong>Space Complexity</strong>: <code>O(1)</code> – In-place reversal using only pointers.</li>
</ul>


<hr>

<h2>✅ Key Takeaways</h2>
<ul>
  <li>Use a dummy node to handle changes at the head.</li>
  <li>Reverse only the required sublist in-place using pointer manipulation.</li>
  <li>Efficient and space-optimal – no extra memory required.</li>
</ul>

</body>
</html>
