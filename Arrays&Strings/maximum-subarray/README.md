
<body>
  <h1>📈 LeetCode 53: Maximum Subarray</h1>

  <h2>📝 Description</h2>
  <p>
    You are given an integer array <code>nums</code>. Find a contiguous subarray (containing at least one number) with the largest sum and return its sum. 
  </p>

  <h2>📊 Example</h2>
  <pre><code>Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6

Explanation: The subarray [4, -1, 2, 1] has the largest sum = 6.</code></pre>

  <h2>🧠 Approach (Kadane’s Algorithm)</h2>
  <ul>
    <li>Use two variables:</li>
    <ul>
      <li><code>sum</code>: running total of the current subarray</li>
      <li><code>larSum</code>: maximum sum found so far (initialized to <code>nums[0]</code>)</li>
    </ul>
    <li>Iterate through each element <code>x</code> in <code>nums</code>:</li>
    <ol>
      <li>Add <code>x</code> to <code>sum</code></li>
      <li>Update <code>larSum = max(larSum, sum)</code></li>
      <li>If <code>sum</code> becomes negative, reset it to <code>0</code> — since a negative running sum hurts future sums.</li>
    </ol>
    <li>This way, you process the array in O(n) time with O(1) extra space.</li>
  </ul>

  <h2>📄 Solution (Java)</h2>
  <pre><code>class Solution {
    public int maxSubArray(int[] nums) {
      int larSum = nums[0];
      int sum = 0;
      for (int x : nums) {
        sum += x;
        larSum = Math.max(larSum, sum);
        if (sum < 0) sum = 0;
      }
      return larSum;
    }
  }</code></pre>

  <div class="note">
    ✅ This is Kadane’s algorithm: single-pass, constant-space, optimal for this problem. 
  </div>

  <h2>⏱️ Complexity</h2>
  <ul>
    <li><strong>Time:</strong> O(n), one pass through the array.</li>
    <li><strong>Space:</strong> O(1), uses only two int variables.</li>
  </ul>

  <h2>📚 References</h2>
  <ul>
    <li>Kadane’s algorithm overview on GeeksforGeeks </li>
    <li>Formal definition on Wikipedia </li>
    <li>Dynamic Programming explanation on Medium</li>
  </ul>
</body>
</html>
