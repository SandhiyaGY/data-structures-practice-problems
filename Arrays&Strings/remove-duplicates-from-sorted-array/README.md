<!DOCTYPE html>

<body>
  <h1>🛑 LeetCode 26: Remove Duplicates from Sorted Array</h1>

  <h2>📝 Description</h2>
  <p>
    Given a sorted integer array <code>nums</code>, remove duplicates in-place so that each unique element appears only once.
    The first <code>k</code> elements of <code>nums</code> should hold the final unique array, and the rest can be disregarded. Return <code>k</code>. 
  </p>

  <h2>📊 Example</h2>
  <pre><code>Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: k = 5, nums = [0,1,2,3,4,_,_,_,_,_]</code></pre>
 

  <h2>🧠 Approach (Two-Pointers)</h2>
  <ul>
    <li>Use **two pointers**:
      <ul>
        <li><code>index</code> tracks the position to place the next unique element</li>
        <li><code>i</code> scans through the array from 1 to <code>n – 1</code></li>
      </ul>
    </li>
    <li>Whenever <code>nums[i] ≠ nums[index]</code>, it's a new unique:</li>
      <ul>
        <li>Increment <code>index</code> and overwrite <code>nums[index]</code> with <code>nums[i]</code></li>
      </ul>
    </li>
    <li>After finishing, <code>k = index + 1</code> is the count of unique elements.</li>
    <li>This runs in **O(n)** time and uses **O(1)** extra space.</li>
  </ul>

  <h2>📄 Solution (Java)</h2>
  <pre><code>class Solution {
  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len == 0) return 0;
    int index = 0;
    for (int i = 1; i < len; i++) {
      if (nums[i] != nums[index]) {
        index++;
        nums[index] = nums[i];
      }
    }
    return index + 1;
  }
}</code></pre>

  <div class="note">
    ✅ This is the classic two-pointer in-place solution: simple, efficient, and doesn't allocate extra memory.
  </div>

  <h2>⏱️ Complexity</h2>
  <ul>
    <li><strong>Time:</strong> O(n) — each element is processed once.</li>
    <li><strong>Space:</strong> O(1) — only uses input array and two integers. </li>
  </ul>

  <h2>📚 References</h2>
  <ul>
    <li>GeeksforGeeks – “Remove duplicates from Sorted Array” </li>
    <li>Medium – Two-pointer in-place explanation </li>
    <li>Stack Overflow & Reddit clarifications on in-place constraint </li>
  </ul>
</body>
</html>
