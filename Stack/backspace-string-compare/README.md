
<body>

  <h1>🔄 <a href="https://leetcode.com/problems/backspace-string-compare">844. Backspace String Compare</a></h1>

  <p>
    Given two strings <code>s</code> and <code>t</code>, return <strong>true</strong> if they are equal when both are typed into empty text editors. 
    The character <code>'#'</code> represents a backspace. :contentReference[oaicite:1]{index=1}
  </p>

  <p>Note: Typing a backspace on an empty text has no effect.</p>

  <h2>📌 Examples</h2>
  <ul>
    <li><code>s = "ab#c", t = "ad#c"</code> → <strong>true</strong> (“ac” == “ac”) </li>
    <li><code>s = "ab##", t = "c#d#"</code> → <strong>true</strong> (both end as “”) </li>
    <li><code>s = "a#c", t = "b"</code> → <strong>false</strong> (“c” != “b”) </li>
  </ul>

  <h2>✅ Provided Java Solution</h2>
  <pre><code>class Solution {
    public boolean backspaceCompare(String s, String t) {
      Stack<Character> st1 = new Stack<>();
      Stack<Character> st2 = new Stack<>();
      for (char ch : s.toCharArray()) {
        if (ch != '#') st1.push(ch);
        else if (!st1.isEmpty()) st1.pop();
      }
      for (char ch : t.toCharArray()) {
        if (ch != '#') st2.push(ch);
        else if (!st2.isEmpty()) st2.pop();
      }
      if (st1.size() != st2.size()) return false;
      while (!st1.isEmpty() && !st2.isEmpty()) {
        if (st1.pop() != st2.pop()) return false;
      }
      return true;
    }
  }</code></pre>

  <h2>🧠 Detailed Approach</h2>
  <ol>
    <li><strong>Simulate typing using two stacks:</strong> one for <code>s</code>, one for <code>t</code>.</li>
    <li>Process each character:<br>
      • If it’s not <code>'#'</code>, push it.<br>
      • Else if stack isn’t empty, pop one character (simulate backspace).</li>
    <li>After both strings are processed, compare the two stacks:<br>
      • If sizes differ → <code>false</code>.<br>
      • Else pop both stacks and compare each character; any mismatch → <code>false</code>.</li>
    <li>If all pops match → <code>true</code>.</li>
  </ol>

  <h2>🔍 Why It Works</h2>
  <ul>
    <li>This simulates exactly how typing with backspaces works—characters removed immediately.</li>
    <li>Each character is pushed once and popped at most once → **O(n)** time, **O(n)** space. :contentReference[oaicite:5]{index=5}</li>
    <li>Follow-up: You can also solve in **O(1)** space using the *reverse two-pointer* technique from the end of the strings. :contentReference[oaicite:6]{index=6}</li>
  </ul>

  <h2>⏱️ Complexity</h2>
  <ul>
    <li><strong>Time:</strong> O(n + m), where n = |s|, m = |t|.</li>
    <li><strong>Space:</strong> O(n + m) due to stacks.</li>
  </ul>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li>Strings ending with multiple <code>'#'</code>.</li>
    <li>Empty resulting string vs non-empty.</li>
    <li>If either string is empty initially.</li>
  </ul>

  <h2>🔄 Alternative (O(1) Space) Approach</h2>
  <p>
    Use two pointers from the end and skip characters based on backspace counts until valid characters are found. Compare step-by-step. Efficient and avoids extra memory, as shown in online solutions. :contentReference[oaicite:7]{index=7}
  </p>

</body>
</html>
