
<body>

  <h1>🎯 <a href="https://leetcode.com/problems/min-stack">155. Min Stack</a></h1>

  <p>
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  </p>

  <h2>📌 Problem Statement</h2>
  <p>
    Implement a stack that supports the following operations:
  </p>
  <ul>
    <li><code>push(x)</code> — Push element <code>x</code> onto stack.</li>
    <li><code>pop()</code> — Removes the element on top of the stack.</li>
    <li><code>top()</code> — Get the top element.</li>
    <li><code>getMin()</code> — Retrieve the minimum element in the stack.</li>
  </ul>

  <h2>📘 Example</h2>
  <pre><code>Input
  ["MinStack","push","push","push","getMin","pop","top","getMin"]
  [[],[-2],[0],[-3],[],[],[],[]]

  Output
  [null,null,null,null,-3,null,0,-2]

  Explanation
  MinStack minStack = new MinStack();
  minStack.push(-2);
  minStack.push(0);
  minStack.push(-3);
  minStack.getMin();   // Returns -3.
  minStack.pop();
  minStack.top();      // Returns 0.
  minStack.getMin();   // Returns -2.</code></pre>

  <h2>📌 Java Solution</h2>
  <pre><code>class MinStack {
    Stack<int[]> st;
    public MinStack() {
        st = new Stack<>();
    }
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new int[] {val, val});
        } else {
            int min = Math.min(val, st.peek()[1]);
            st.push(new int[] {val, min});
        }
    }
    public void pop() {
        st.pop();
    }
    public int top() {
        return st.peek()[0];
    }
    public int getMin() {
        return st.peek()[1];
    }
}</code></pre>

  <h2>🧠 Explanation</h2>
  <p>
    The <code>MinStack</code> class uses a stack to store pairs of values. Each pair consists of:
  </p>
  <ul>
    <li>The actual value.</li>
    <li>The minimum value in the stack up to that point.</li>
  </ul>
  <p>
    When a value is pushed, it's added to the stack along with the current minimum. When a value is popped, both the value and its associated minimum are removed. The <code>getMin()</code> method retrieves the minimum value by accessing the second element of the top pair in the stack.
  </p>

  <h2>🔍 Time Complexity</h2>
  <ul>
    <li><code>push(x)</code>: O(1)</li>
    <li><code>pop()</code>: O(1)</li>
    <li><code>top()</code>: O(1)</li>
    <li><code>getMin()</code>: O(1)</li>
  </ul>
  <p>
    All operations are performed in constant time.
  </p>


</body>
</html>
