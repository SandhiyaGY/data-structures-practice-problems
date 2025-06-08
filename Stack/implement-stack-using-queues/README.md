
<body>

  <h1>🎯 <a href="https://leetcode.com/problems/implement-stack-using-queues">225. Implement Stack using Queues</a></h1>

  <p>
    Design a stack (Last-In-First-Out behavior) using only two queues. Support the standard operations: <code>push</code>, <code>pop</code>, <code>top</code>, and <code>empty</code>.
  </p>

  <h2>📌 Solution Provided (Java)</h2>
  <pre><code>class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    public int pop() {
        return q1.remove();
    }
    public int top() {
        return q1.peek();
    }
    public boolean empty() {
        return q1.isEmpty();
    }
}</code></pre>

  <h2>🧠 Detailed Approach</h2>
  <ol>
    <li><strong>Maintain two queues.</strong> We’ll use <code>q1</code> to represent the stack and <code>q2</code> as a temporary helper.</li>
    <li><strong>push(x):</strong>
      <ul>
        <li>Add <code>x</code> to <code>q2</code>.</li>
        <li>Dequeue all elements from <code>q1</code> into <code>q2</code>, ensuring <code>x</code> ends up at front.</li>
        <li>Swap <code>q1</code> and <code>q2</code>, so <code>x</code> is now at the front of <code>q1</code>.</li>
      </ul>
    </li>
    <li><strong>pop():</strong> Dequeue from front of <code>q1</code> (O(1)).</li>
    <li><strong>top():</strong> Peek front of <code>q1</code> without removing (O(1)).</li>
    <li><strong>empty():</strong> Check if <code>q1</code> is empty.</li>
  </ol>

  <h2>🔍 Why It Works</h2>
  <ul>
    <li>By rotating elements on each <code>push</code>, the newest element is always at the front of <code>q1</code>, replicating the stack "top". </li>
    <li>All operations except <code>push</code> run in O(1) time, while <code>push</code> takes O(n) time (due to moving n existing elements). </li>
  </ul>

  <h2>⏱️ Complexity Analysis</h2>
  <ul>
    <li><strong>Time Complexity:</strong>
      <ul>
        <li><code>push</code>: O(n), where n = current stack size.</li>
        <li><code>pop</code>, <code>top</code>, <code>empty</code>: O(1).</li>
      </ul>
    </li>
    <li><strong>Space Complexity:</strong> O(n), for storing elements in queues.</li>
  </ul>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li>Pushing to an empty stack initializes the element in <code>q1</code>.</li>
    <li>Performing <code>pop</code> or <code>top</code> on an empty stack leads to exception—LeetCode guarantees valid calls.</li>
  </ul>

  <h2>🔄 Alternative One-Queue Solution</h2>
  <p>
    You can also use a single queue by rotating it on each <code>push</code>: enqueue <code>x</code>, then rotate the first <code>queue.size() – 1</code> elements from front to back. This keeps the new element at front. 
  </p>

</body>
</html>
