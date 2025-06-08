
  <h1>🔐 <a href="https://leetcode.com/problems/valid-parentheses">20. Valid Parentheses</a></h1>

  <p>
    Given a string <code>s</code> containing just the characters <code>'(', ')', '{', '}', '[', ']'</code>, determine if the input string is <strong>valid</strong>. :contentReference[oaicite:1]{index=1}
  </p>
  <p>An input string is valid if:</p>
  <ul>
    <li>Open brackets are closed by the <strong>same type</strong> of bracket.</li>
    <li>Brackets are closed in the <strong>correct order</strong>.</li>
    <li>An empty string is also considered valid.</li>
  </ul>

  <h2>📌 Examples</h2>
  <ul>
    <li><code>s = "()"</code> → <strong>true</strong></li>
    <li><code>s = "()[]{}"</code> → <strong>true</strong></li>
    <li><code>s = "(]"</code> → <strong>false</strong></li>
    <li><code>s = "([])"</code> → <strong>true</strong></li>
  </ul>

  <h2>✅ Java Solution</h2>
  <pre><code>class Solution {
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for (char ch : s.toCharArray()) {
        if (ch=='[' || ch=='{' || ch=='(') {
          stack.push(ch);
        }
        else if (!stack.isEmpty() &&
                 ((stack.peek()=='[' && ch==']') ||
                  (stack.peek()=='{' && ch=='}') ||
                  (stack.peek()=='(' && ch==')'))) {
          stack.pop();
        }
        else {
          return false;
        }
      }
      return stack.isEmpty();
    }
  }</code></pre>

  <h2>🧠 Detailed Approach</h2>
  <ol>
    <li><strong>Use a stack to track opening brackets</strong> in **LIFO order**.</li>
    <li>For each character <code>ch</code> in <code>s</code>:
      <ul>
        <li>If it's an **opening bracket** (<code>( [ {</code>), **push** it onto the stack.</li>
        <li>Otherwise (it's a closing bracket):
          <ul>
            <li>If the stack is **empty**, there’s no matching opener → **return false**.</li>
            <li>Else, check if <code>stack.peek()</code> pairs with <code>ch</code> (e.g., <code>(,)</code>, <code>[,]</code>, <code>{,}</code>). If yes: **pop**; if no: **return false**.</li>
          </ul>
        </li>
      </ul>
    </li>
    <li>After processing, if the stack is **empty**, return **true** (all brackets matched); otherwise, **false**.</li>
  </ol>

  <h2>🔍 Why It Works</h2>
  <ul>
    <li>The stack enforces **proper nesting**: the most recent opener must match the next closer.</li>
    <li>Each character is handled once → **O(n)** time complexity.</li>
    <li>Stack uses at most **O(n)** space in the worst case.</li>
  </ul>

  <h2>🧪 Edge Cases</h2>
  <ul>
    <li>Empty string → valid.</li>
    <li>Odd-length strings → invalid.</li>
    <li>Strings starting with a closer → invalid.</li>
    <li>Improper nesting (e.g. <code>"([)]"</code>) → invalid.</li>
  </ul>

  <h2>⏱️ Complexity</h2>
  <ul>
    <li><strong>Time:</strong> O(n)</li>
    <li><strong>Space:</strong> O(n)</li>
  </ul>

</body>
</html>
