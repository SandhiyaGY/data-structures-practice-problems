<!DOCTYPE html>
<html lang="en">


<body>

  <h1><a href="https://leetcode.com/problems/copy-list-with-random-pointer/" target="_blank">138.Copy List with Random Pointer</a></h1>
  
 <h2>Description</h2>

  <!-- description:start -->
  <p>A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.</p>
  
  <p>Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

</p>

  <p>For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.</p>
<p>Return the head of the copied linked list.</p>

<p>The linked list is represented in the input/output as a list of <code>n</code> nodes. Each node is represented as a pair of <code>[val, random_index]</code> where:</p>

<p><strong>val:</strong> an integer representing <code>Node.val</code></p>

<p><strong>random_index:</strong> the index of the node (range from <code>0</code> to <code>n−1</code>) that the <code>random</code> pointer points to, or <code>null</code> if it does not point to any node.</p>

<p>Your code will only be given the head of the original linked list.</p>

  <h3>Example 1:</h3>
  <img src="https://assets.leetcode.com/uploads/2019/12/18/e1.png" alt="Example image" style="width:900px">
  <pre><code>Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]</code></pre>

  <h3>Example 2:</h3>
  <img src="https://assets.leetcode.com/uploads/2019/12/18/e2.png" alt="Example image" style="width:900px">
  <pre><code>Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]</code></pre>

  <h3>Example 3:</h3>
  <img src="https://assets.leetcode.com/uploads/2019/12/18/e3.png" alt="Example image" style="width:900px">
  <pre><code>Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
</code></pre>

  <div class="section">
    <h2>💡 Solution Approaches</h2>
    <h3>Approach : HashMap (O(n) time, O(n) space)</h3>
    <ol>
      <li>Traverse the list and for each node, create a clone in a <code>HashMap&lt;Node, Node&gt;</code>.</li>
      <li>Traverse again to set <code>clone.next</code> and <code>clone.random</code> using the map.</li>
      <li>Return the cloned head.</li>
    </ol>
    <pre><code>public Node copyRandomList(Node head) {
    if (head == null) return null;
    Map<Node, Node> map = new HashMap<>();
    Node cur = head;
    while (cur != null) {
        map.put(cur, new Node(cur.val));
        cur = cur.next;
    }
    cur = head;
    while (cur != null) {
        Node copy = map.get(cur);
        copy.next = map.get(cur.next);
        copy.random = map.get(cur.random);
        cur = cur.next;
    }
    return map.get(head);
}</code></pre>


</body>
</html>
