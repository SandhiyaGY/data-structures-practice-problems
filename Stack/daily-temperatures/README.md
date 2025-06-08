
<body>

  <h1>🌡️ <a href="https://leetcode.com/problems/daily-temperatures">739. Daily Temperatures</a></h1>

  <p>
    Given an integer array <code>temperatures</code>, return an array <code>result</code> such that <code>result[i]</code>
    is the number of days you have to wait after the <code>i</code>-th day to get a warmer temperature.
    If there is no future warmer day, <code>result[i] = 0</code>.
  </p>
 <h2>✅ LeetCode Examples</h2>
  Example 1:
  <pre><code>Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
</code></pre>
Example 2:
<pre><code>Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
</code></pre>
Example 3:
<pre><code>Input: temperatures = [30,60,90]
Output: [1,1,0]</code></pre>

  <h2>📌 Java Solution (Monotonic Stack)</h2>
  <pre><code>class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int n = temperatures.length;
      int[] result = new int[n];
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
          int j = stack.pop();
          result[j] = i - j;
        }
        stack.push(i);
      }
      return result;
    }
}</code></pre>

  <h2>🧠 Detailed Step-by-Step Example</h2>
  <p>Using <code>temperatures = [73,74,75,71,69,72,76,73]</code>:</p>
  <ol>
    <li>Initialize <code>result = [0,0,0,0,0,0,0,0]</code>, stack = <code>[]</code>.</li>
    <li><strong>Day 0</strong> (73): stack is empty → push <code>0</code>. stack = [0].</li>
    <li><strong>Day 1</strong> (74): 74 > 73 → pop 0 → result[0] = 1. Push 1. stack = [1].</li>
    <li><strong>Day 2</strong> (75): 75 > 74 → pop 1 → result[1] = 1. Push 2.</li>
    <li><strong>Day 3</strong> (71): 71 ≤ 75 → push 3.</li>
    <li><strong>Day 4</strong> (69): 69 ≤ 71 → push 4.</li>
    <li><strong>Day 5</strong> (72): 72 > 69 → pop 4 → result[4] = 1. 72 > 71 → pop 3 → result[3] = 2. Push 5.</li>
    <li><strong>Day 6</strong> (76): 76 > 72 → pop 5 → result[5] = 1. 76 > 75 → pop 2 → result[2] = 4. Push 6.</li>
    <li><strong>Day 7</strong> (73): 73 ≤ 76 → push 7.</li>
    <li>End loop. Remaining stack indices (6,7) have no warmer day → result stays 0.</li>
  </ol>

  <p>
    Final <code>result = [1,1,4,2,1,1,0,0]</code>, matching the expected output.  
    ⏱️ Each index is pushed and popped at most once → <strong>O(n)</strong> time.
  </p>
  <p>This walkthrough aligns with the algorithm’s logic using a monotonic stack, efficiently resolving multiple previous days in one go. :contentReference[oaicite:0]{index=0}</p>

  <h2>🔍 Why This Method Works</h2>
  <ul>
    <li>Stack preserves indices of days with unresolved warmer days, in decreasing temperature order.</li>
    <li>When a warmer day arrives, it immediately resolves all cooler days in the stack, in one pass.</li>
    <li>Each element is visited at most twice (push + pop), guaranteeing linear time complexity. :contentReference[oaicite:1]{index=1}</li>
  </ul>

  <h2>⏱️ Complexity Analysis</h2>
  <ul>
    <li><strong>Time:</strong> O(n)</li>
    <li><strong>Space:</strong> O(n) due to the stack and output array</li>
  </ul>

 
</body>
</html>
