
<body>
  <h1>📌 LeetCode 88: Merge Sorted Array</h1>

  <h2>📝 Description</h2>
  <p>
    Given two sorted integer arrays <code>nums1</code> (length <code>m + n</code>, with first <code>m</code> valid elements) and <code>nums2</code> (length <code>n</code>),
    merge them in non-decreasing order so that the result is stored in-place in <code>nums1</code>. Do not return anything from the function. 
  </p>

  <h2>📊 Example</h2>
  <pre><code>Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

After merge, nums1 becomes: [1,2,2,3,5,6]
</code></pre>

  <h2>🧠 Approach (Two-Pointer from End)</h2>
  <ul>
    <li>Use three pointers:
      <ul>
        <li><code>i = m - 1</code>: last valid element in <code>nums1</code></li>
        <li><code>j = n - 1</code>: last element in <code>nums2</code></li>
        <li><code>k = m + n - 1</code>: last position in <code>nums1</code> buffer</li>
      </ul>
    <li>Iterate while <code>i >= 0 && j >= 0</code>:
      <ul>
        <li>Compare <code>nums1[i]</code> and <code>nums2[j]</code></li>
        <li>Place the larger at <code>nums1[k]</code></li>
        <li>Move corresponding pointer backward (<code>i--</code> or <code>j--</code>) and <code>k--</code></li>
      </ul>
    <li>If <code>nums2</code> still has elements (<code>j >= 0</code>), copy remaining items into front of <code>nums1</code></li>
    <li>No need to copy <code>nums1</code> leftovers—they are already in place</li>
    <li>This avoids overwriting yet-to-be-processed items and works in-place in **O(m + n)** time and **O(1)** extra space.</li>
  </ul>

  <h2>💡 Solution (Java)</h2>
  <pre><code>class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
}</code></pre>
  <div class="note">
    ✅ Efficient in-place merge: no extra buffers, reversed merge ensures safety.
  </div>

  <h2>⏱️ Complexity</h2>
  <ul>
    <li><strong>Time:</strong> O(m + n), each pointer moves at most total of m+n steps.</li>
    <li><strong>Space:</strong> O(1), in-place operation using constant extra variables.</li>
  </ul>

  <h2>📚 References</h2>
  <ul>
    <li>Problem overview & two-pointer intuition (AlgoMonster)</li>
    <li>Accepted Java solution examples (Medium) </li>
    <li>Reddit discussion confirming simplicity of two-pointer method </li>
  </ul>
</body>
</html>
