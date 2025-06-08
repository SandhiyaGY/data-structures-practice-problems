

  <h1>🎯 <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation">150. Evaluate Reverse Polish Notation</a></h1>

  <p>
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are <code>+</code>, <code>-</code>, <code>*</code>, and <code>/</code>.
    Each operand may be an integer or another expression.
  </p>
<h2>📚 Examples </h2>
  <h3>Example 1:</h3>
  <pre><code>Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9</code></pre>

  <h3>Example 2:</h3>
  <pre><code>Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6</code></pre>

  <h3>Example 3:</h3>
  <pre><code>Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22</code></pre>
  <h2>📌 Solution Provided (Java)</h2>
  <pre><code>class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
            } else if (token.equals("-")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            } else if (token.equals("*")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
            } else if (token.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a / b);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}</code></pre>

  <h2>🧠 Detailed Approach</h2>
  <ol>
    <li><strong>Initialize a Stack:</strong> Create an empty stack to hold operands.</li>
    <li><strong>Iterate Through Tokens:</strong> Loop through each token in the input array.</li>
    <li><strong>Handle Operators:</strong> For each operator (<code>+</code>, <code>-</code>, <code>*</code>, <code>/</code>):
      <ul>
        <li>Pop the top two operands from the stack.</li>
        <li>Apply the operator to these operands.</li>
        <li>Push the result back onto the stack.</li>
      </ul>
    </li>
    <li><strong>Handle Operands:</strong> If the token is a number:
      <ul>
        <li>Convert it to an integer.</li>
        <li>Push it onto the stack.</li>
      </ul>
    </li>
    <li><strong>Return Result:</strong> After processing all tokens, the stack will contain one element, which is the result of the expression.</li>
  </ol>

  <h2>🔍 Why It Works</h2>
  <ul>
    <li>Reverse Polish Notation (RPN) eliminates the need for parentheses and operator precedence rules.</li>
    <li>Using a stack allows us to evaluate the expression in a single pass from left to right.</li>
    <li>Each operator applies to the two most recent operands, ensuring correct evaluation order.</li>
  </ul>

  <h2>⏱️ Complexity Analysis</h2>
  <ul>
    <li><strong>Time Complexity:</strong> O(n) – We process each token exactly once.</li>
    <li><strong>Space Complexity:</strong> O(n) – The stack stores up to n operands at any time.</li>
  </ul>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li><strong>Single Operand:</strong> Input: <code>["3"]</code> → Output: <code>3</code></li>
    <li><strong>Negative Numbers:</strong> Input: <code>["-2", "1", "+"]</code> → Output: <code>-1</code></li>
    <li><strong>Large Numbers:</strong> Input: <code>["100", "200", "+", "3", "*"]</code> → Output: <code>900</code></li>
  </ul>

  

</body>
</html>
