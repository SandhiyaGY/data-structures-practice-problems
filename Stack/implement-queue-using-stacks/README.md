
<body>

  <h1>🎯 <a href="https://leetcode.com/problems/implement-queue-using-stacks">232. Implement Queue using Stacks</a></h1>

  <p>
    Implement a first-in, first-out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue: <code>push</code>, <code>peek</code>, <code>pop</code>, and <code>empty</code>.
  </p>

  <h2>📌 Solution Provided (Java)</h2>
  <pre><code>class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int front;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        if (st1.isEmpty()) {
            front = x;
        }
        st1.push(x);
    }

    public int pop() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int last = st2.pop();
        if (!st2.isEmpty()) {
            front = st2.peek();
        }
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return last;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return st1.isEmpty();
    }
}</code></pre>

  <h2>🧠 Detailed Approach</h2>
  <ol>
    <li><strong>Two Stacks:</strong> Utilize two stacks, <code>st1</code> for enqueue operations and <code>st2</code> for dequeue operations.</li>
    <li><strong>Push Operation:</strong> Push elements onto <code>st1</code>. If <code>st1</code> is empty, set the <code>front</code> variable to the new element.</li>
    <li><strong>Pop Operation:</strong> Transfer all elements from <code>st1</code> to <code>st2</code>, pop the top element from <code>st2</code> (which is the front of the queue), and then transfer all elements back to <code>st1</code>.</li>
    <li><strong>Peek Operation:</strong> Return the <code>front</code> variable, which holds the front element of the queue.</li>
    <li><strong>Empty Operation:</strong> Check if <code>st1</code> is empty to determine if the queue is empty.</li>
  </ol>

  <h2>🔍 Why It Works</h2>
  <ul>
    <li>By using two stacks, we can simulate the FIFO behavior of a queue. The elements are reversed twice: first when transferring from <code>st1</code> to <code>st2</code>, and second when transferring back to <code>st1</code>.</li>
    <li>The <code>front</code> variable keeps track of the front element without needing to traverse the stacks.</li>
  </ul>

  <h2>⏱️ Complexity Analysis</h2>
  <ul>
    <li><strong>Time Complexity:</strong>
      <ul>
        <li><code>push(x)</code>: O(1) – Pushing an element onto <code>st1</code> is constant time.</li>
        <li><code>pop()</code>: O(n) – In the worst case, all elements are transferred from <code>st1</code> to <code>st2</code> and back.</li>
        <li><code>peek()</code>: O(1) – Accessing the <code>front</code> variable is constant time.</li>
        <li><code>empty()</code>: O(1) – Checking if <code>st1</code> is empty is constant time.</li>
      </ul>
    </li>
    <li><strong>Space Complexity:</strong> O(n) – Two stacks are used to store the elements.</li>
  </ul>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li>Performing <code>pop()</code> or <code>peek()</code> on an empty queue will result in an exception. Ensure that these operations are only called when the queue is not empty.</li>
  </ul>

</body>
</html>
