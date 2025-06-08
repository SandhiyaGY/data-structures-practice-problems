
<body>

  <h1>🎯 <a href="https://leetcode.com/problems/valid-parenthesis-string">678. Valid Parenthesis String</a></h1>

  <p>
    Given a string <code>s</code> containing only three types of characters: <code>'('</code>, <code>')'</code>, and <code>'*'</code>, return <code>true</code> if <code>s</code> is valid.
  </p>

  <p><strong>Rules:</strong><br>
  - <code>'('</code> must be closed by <code>')'</code>.<br>
  - <code>')'</code> must be opened by <code>'('</code>.<br>
  - Parentheses close in correct order.<br>
  - <code>'*'</code> can act as <code>'('</code>, <code>')'</code>, or empty string. :contentReference[oaicite:0]{index=0}</p>

  <h2>📌 Provided Solution (Java)</h2>
  <pre><code>class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open.push(i);
            } else if (ch == '*') {
                star.push(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!open.isEmpty() && !star.isEmpty()) {
            if (open.pop() > star.pop()) {
                return false;
            }
        }
        return open.isEmpty();
    }
}</code></pre>

  <h2>🧠 Detailed Approach</h2>
  <ol>
    <li>Use two stacks to hold indices of <code>'('</code> and <code>'*'</code>.</li>
    <li>On encountering <code>')'</code>, first match with the most recent <code>'('</code>, or if none, match with a <code>'*'</code>; if neither exists, return <code>false</code>.</li>
    <li>After processing all characters, leftover <code>'('</code> must be matched by <code>'*'</code> that appear *after* them. Pop one from each and ensure the index of <code>'*'</code> is greater. If any <code>'('</code> remains unmatched, return <code>false</code>.</li>
    <li>If all <code>'('</code> are matched, the string is valid.</li>
  </ol>

  <h2>🔍 Why It Works</h2>
  <ul>
    <li>Tracks positions of <code>'('</code> and <code>'*'</code> separately.</li>
    <li>Whenever possible, uses real <code>'('</code> to match <code>')'</code>, else leverages <code>'*'</code>.</li>
    <li>Final alignment ensures stars can substitute as right parentheses in correct order. This stack-based greedy matches indices successfully in one forward pass + small cleanup :contentReference[oaicite:1]{index=1}.</li>
  </ul>

  <h2>⌛ Complexity</h2>
  <ul>
    <li><strong>Time:</strong> O(n), where n = length of <code>s</code>. Each character is pushed and popped at most once.</li>
    <li><strong>Space:</strong> O(n), for two stacks.</li>
  </ul>

  <h2>🔄 Alternative (Greedy Range Counting, O(1) space)</h2>
  <p>
    Instead of stacks, maintain two counters <code>low</code> and <code>high</code>:
    - <code>low</code> = minimal possible number of unmatched “(”s,
    - <code>high</code> = maximal possible number.
  </p>
  <ul>
    <li>On <code>'('</code>: <code>low++, high++</code></li>
    <li>On <code>')'</code>: <code>low = max(0, low - 1); high--</code></li>
    <li>On <code>'*'</code>: <code>low = max(0, low - 1); high++</code></li>
    <li>If at any point <code>high &lt; 0</code>: return <code>false</code>. At end, return <code>low == 0</code>. :contentReference[oaicite:2]{index=2}</li>
  </ul>

  <h2>✅ Examples</h2>
  <pre><code>s = "()": true  
s = "(*)": true  
s = "(*))": true</code></pre>

</body>
</html>
