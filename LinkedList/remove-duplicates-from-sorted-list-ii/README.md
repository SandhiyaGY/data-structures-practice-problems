
<h1><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii">82. Remove Duplicates from Sorted List II</a></h1>

<h2>📝 Problem Description</h2>
<p>Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.</p>

<hr>

<h2>📥 Input and 📤 Output</h2>

<h3>Example 1</h3>
<img src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" alt="Example 1" style="width: 400px;">
<pre><code>Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
</code></pre>

<h3>Example 2</h3>
<img src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg" alt="Example 2" style="width: 400px;">
<pre><code>Input: head = [1,1,1,2,3]
Output: [2,3]
</code></pre>

<hr>

<h2>📚 Constraints</h2>
<ul>
  <li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
  <li>The list is guaranteed to be sorted in ascending order.</li>
</ul>

<hr>

<h2>💡 Approach: Sentinel Dummy Node + Skip Duplicates</h2>

<h3>🔄 Intuition:</h3>
<p>Because the list is sorted, duplicates will be adjacent. We use a dummy node to handle edge cases where the head itself needs to be removed. The idea is to only link nodes that have no duplicates.</p>

<h3>🧱 Steps:</h3>
<ol>
  <li>Create a dummy node pointing to the head.</li>
  <li>Use two pointers: <code>result</code> to build the new list, and <code>head</code> to iterate through the original list.</li>
  <li>If a duplicate is found (current node equals next node), skip all nodes with that value.</li>
  <li>If no duplicate, move the <code>result</code> pointer to the next node.</li>
  <li>Return <code>dummy.next</code> as the new head.</li>
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode result = dummy;
        while (head != null) {
            if (head.next != null && head.val != head.next.val) {
                result = result.next;
            } else if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                result.next = head.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
</code></pre>

<hr>

<h2>⏱️ Complexity Analysis</h2>
<ul>
  <li><strong>Time Complexity</strong>: <code>O(n)</code> – We traverse each node once.</li>
  <li><strong>Space Complexity</strong>: <code>O(1)</code> – No extra space used (in-place modification).</li>
</ul>

<hr>

<h2>✅ Key Takeaways</h2>
<ul>
  <li>Dummy nodes are useful for edge cases involving the head node.</li>
  <li>When handling duplicates in a sorted list, it's efficient to skip over all duplicate values in one pass.</li>
  <li>Ensure you're always maintaining the correct pointers when modifying the list.</li>
</ul>

</body>
</html>
