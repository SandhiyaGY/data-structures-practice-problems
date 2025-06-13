
<body>
  <h1>🔢 LeetCode 1: Two Sum (Brute‑Force Java)</h1>

  <h2>📘 Problem Description</h2>
  <p>
    Given an integer array <code>nums</code> and an integer <code>target</code>, return the indices of the two entries whose values add up to <code>target</code>.
    You may assume exactly one solution exists, and you cannot use the same element twice :contentReference[oaicite:1]{index=1}.
  </p>
<h2>📊 Example</h2>
  <pre><code>Input: nums = [2, 7, 11, 15], target = 9  
Output: [0, 1]

Explanation: nums[0] + nums[1] = 2 + 7 = 9 → indices [0, 1].</code></pre>

  <h2>📚 Further Reading & Alternatives</h2>
  <ul>
    <li>LeetCode Two Sum problem overview and examples :contentReference[oaicite:4]{index=4}.</li>
    <li>More efficient O(n) solution using a hash map from StudyTonight :contentReference[oaicite:5]{index=5}.</li>
  </ul>
  <h2>🛠️ Brute‑Force Java Solution</h2>
  <pre><code>class Solution {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {0, 0};  // default, but problem guarantees a solution
  }
}</code></pre>

  <div class="note">
    <strong>Note:</strong> This uses a nested loop—checking every pair—simple and straightforward, but not optimal. :contentReference[oaicite:2]{index=2}
  </div>

  <h2>⏱️ Complexity Analysis</h2>
  <ul>
    <li><strong>Time Complexity:</strong> O(n²) – due to the double loop over <code>nums</code> :contentReference[oaicite:3]{index=3}.</li>
    <li><strong>Space Complexity:</strong> O(1) – uses only constant extra space.</li>
  </ul>
</body>
</html>
