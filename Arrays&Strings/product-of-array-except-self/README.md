<!DOCTYPE html>

<body>
  <h1>✖️ Product of Array Except Self</h1>

  <h2>📝 Problem Description</h2>
  <p>Given an integer array <code>nums</code>, return an array <code>answer</code> such that <code>answer[i]</code> is equal to the product of all the elements of <code>nums</code> except <code>nums[i]</code>.</p>
  <p>You must solve it <strong>without using division</strong> and in <code>O(n)</code> time.</p>

  <h2>📌 Example</h2>
  <ul>
    <li><strong>Input:</strong> <code>nums = [1,2,3,4]</code></li>
    <li><strong>Output:</strong> <code>[24,12,8,6]</code></li>
    <li><strong>Explanation:</strong> 
      <ul>
        <li>answer[0] = 2 * 3 * 4 = 24</li>
        <li>answer[1] = 1 * 3 * 4 = 12</li>
        <li>answer[2] = 1 * 2 * 4 = 8</li>
        <li>answer[3] = 1 * 2 * 3 = 6</li>
      </ul>
    </li>
  </ul>

  <h2>💡 Approach</h2>
  <p>We use two passes to build the result without using extra space for left and right product arrays:</p>
  <ol>
    <li>First pass (left to right): 
      <ul>
        <li>Store the product of all elements to the left of the current index in the <code>ans</code> array.</li>
      </ul>
    </li>
    <li>Second pass (right to left): 
      <ul>
        <li>Multiply the current value in <code>ans</code> by the product of elements to the right.</li>
      </ul>
    </li>
  </ol>

  <p><strong>Time Complexity:</strong> <code>O(n)</code><br>
     <strong>Space Complexity:</strong> <code>O(1)</code> (excluding output array)</p>

  <h2>✅ Java Solution</h2>
  <pre><code>class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int prod = 1;
        // Pass 1: Calculate prefix product
        for (int i = 0; i &lt; n; i++) {
            ans[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        // Pass 2: Multiply with suffix product
        for (int i = n - 1; i &gt;= 0; i--) {
            ans[i] *= prod;
            prod *= nums[i];
        }
        return ans;
    }
}</code></pre>
</body>
</html>
