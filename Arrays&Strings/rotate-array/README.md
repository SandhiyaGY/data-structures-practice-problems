
<body>
  <h1>🔄 Rotate Array</h1>

  <h2>📝 Problem Description</h2>
  <p>Given an integer array <code>nums</code>, rotate the array to the right by <code>k</code> steps, where <code>k</code> is non-negative.</p>

  <h2>📌 Example</h2>
  <ul>
    <li><strong>Input:</strong> <code>nums = [1,2,3,4,5,6,7], k = 3</code></li>
    <li><strong>Output:</strong> <code>[5,6,7,1,2,3,4]</code></li>
    <li><strong>Explanation:</strong> Rotate the array to the right by 3 steps.</li>
  </ul>

  <h2>💡 Approach</h2>
  <p>This approach uses a <code>List</code> and leverages the <code>Collections.reverse()</code> method to rotate the array:</p>
  <ol>
    <li>Normalize <code>k</code> by taking <code>k % n</code> to handle cases where <code>k &gt; n</code>.</li>
    <li>Copy the array into a <code>List</code> for easy manipulation.</li>
    <li>Reverse the entire list.</li>
    <li>Reverse the first <code>k</code> elements.</li>
    <li>Reverse the remaining <code>n - k</code> elements.</li>
    <li>Copy the final list back into the original array.</li>
  </ol>

  <p><strong>Time Complexity:</strong> <code>O(n)</code><br>
     <strong>Space Complexity:</strong> <code>O(n)</code> due to use of extra list.</p>

  <h2>✅ Java Solution</h2>
  <pre><code>import java.util.*;
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        List&lt;Integer&gt; list = new ArrayList&lt;&gt;();
        for (int i = 0; i &lt; n; i++) {
            list.add(nums[i]);
        }
        Collections.reverse(list);
        Collections.reverse(list.subList(0, k));
        Collections.reverse(list.subList(k, n));
        for (int i = 0; i &lt; n; i++) {
            nums[i] = list.get(i);
        }
    }
}</code></pre>
</body>
</html>
