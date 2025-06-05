
<h1><a href="https://leetcode.com/problems/reorder-list/" target="_blank">143. Reorder List</a></h1>

<p><strong>Difficulty:</strong> Medium</p>

<hr>

<h2>🧩 Problem Statement</h2>
<p>You are given the head of a singly linked list. The list can be represented as:</p>
<pre>L0 → L1 → … → Ln - 1 → Ln</pre>
<p>Reorder the list to be in the following form:</p>
<pre>L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …</pre>
<p><strong>Note:</strong> You may not modify the values in the list's nodes. Only nodes themselves may be changed.</p>

<hr>

<h2>📷 Example 1:</h2>
<img src="https://assets.leetcode.com/uploads/2021/03/04/reorder1linked-list.jpg" alt="Example 1" width="400">

<pre>
Input: head = [1,2,3,4]
Output: [1,4,2,3]
</pre>

<h2>📷 Example 2:</h2>
<img src="https://assets.leetcode.com/uploads/2021/03/09/reorder2-linked-list.jpg" alt="Example 2" width="400">

<pre>
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
</pre>

<hr>

<h2>📌 Constraints</h2>
<ul>
  <li>The number of nodes in the list is in the range <code>[1, 5 * 10⁴]</code>.</li>
  <li><code>1 <= Node.val <= 1000</code></li>
</ul>

<hr>

<h2>💡 Approach</h2>
<p>This solution stores all nodes in an <code>ArrayList</code> and uses two pointers to reorder the list:</p>
<ol>
  <li>Traverse the list and add all nodes to an <code>ArrayList</code>.</li>
  <li>Use two pointers: <code>left</code> at 0 and <code>right</code> at size - 1.</li>
  <li>Set <code>left.next = right</code> and <code>right.next = left + 1</code>, moving inward.</li>
  <li>Break when <code>left >= right</code>, and set the last node's <code>next = null</code>.</li>
</ol>

<hr>

<h2>🧾 Java Code</h2>

```java
class Solution {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> ll = new ArrayList<>();
        ListNode temp = head;
        
        // Step 1: Store nodes in a list
        while (temp != null) {
            ll.add(temp);
            temp = temp.next;
        }

        // Step 2: Reorder using two pointers
        int left = 0, right = ll.size() - 1;
        while (left < right) {
            ll.get(left).next = ll.get(right);
            left++;
            if (left == right) break;
            ll.get(right).next = ll.get(left);
            right--;
        }

        // Step 3: Terminate the list
        ll.get(left).next = null;
    }
}
```

<hr>

<h2>⏱️ Complexity Analysis</h2>
<ul>
  <li><strong>Time Complexity:</strong> O(n)</li>
  <li><strong>Space Complexity:</strong> O(n) — for storing nodes in the ArrayList</li>
</ul>

<hr>

<h2>🧠 Key Takeaways</h2>
<ul>
  <li>Do not modify node values — only links.</li>
  <li>Using an ArrayList makes access easier for reordering.</li>
  <li>Remember to set the <code>next</code> of the last node to <code>null</code> to avoid infinite loops.</li>
</ul>

</body>
</html>
