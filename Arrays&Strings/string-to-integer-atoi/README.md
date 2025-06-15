
<body>
  <h1>🔢 String to Integer (atoi)</h1>

  <h2>📝 Problem Description</h2>
  <p>Implement the <code>myAtoi(string s)</code> function, which converts a string to a 32-bit signed integer according to the following rules:</p>
  <ul>
    <li>Discard leading whitespace characters.</li>
    <li>Check for an optional '+' or '-' sign.</li>
    <li>Read digits until a non-digit character is encountered.</li>
    <li>Clamp the result within the 32-bit signed integer range: [−2<sup>31</sup>, 2<sup>31</sup> − 1].</li>
    <li>If no valid conversion can be performed, return 0.</li>
  </ul>

  <h2>📌 Example</h2>
  <ul>
    <li><strong>Input:</strong> <code>"   -42"</code></li>
    <li><strong>Output:</strong> <code>-42</code></li>
    <li><strong>Explanation:</strong> The function discards whitespaces, reads the '-' sign, and parses "42".</li>
  </ul>

  <h2>💡 Approach</h2>
  <ol>
    <li>Trim leading whitespaces.</li>
    <li>Check for optional '+' or '-' sign to determine the sign of the result.</li>
    <li>Iterate through the characters and process digits only.</li>
    <li>Use overflow detection logic:
      <ul>
        <li>Use a threshold (Integer.MAX_VALUE / 10).</li>
        <li>If overflow is about to occur, return Integer.MAX_VALUE or Integer.MIN_VALUE accordingly.</li>
      </ul>
    </li>
    <li>Return the computed result multiplied by its sign.</li>
  </ol>

  <p><strong>Time Complexity:</strong> <code>O(n)</code> where <code>n</code> is the length of the string.</p>
  <p><strong>Space Complexity:</strong> <code>O(1)</code> (constant space).</p>

  <h2>✅ Java Solution</h2>
  <pre><code>class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        int i = 0, n = s.length();
        // Skip leading whitespaces
        while (i &lt; n &amp;&amp; s.charAt(i) == ' ') i++;
        if (i == n) return 0;
        // Check for sign
        int sign = 1;
        char c = s.charAt(i);
        if (c == '+' || c == '-') {
            sign = (c == '-') ? -1 : 1;
            i++;
        }
        // Convert digits
        int result = 0;
        int limit = Integer.MAX_VALUE / 10;
        while (i &lt; n) {
            c = s.charAt(i);
            if (!Character.isDigit(c)) break;
            int digit = c - '0';
            if (result > limit || (result == limit &amp;&amp; digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
}</code></pre>
</body>
</html>
