
<body>

  <h1>📁 <a href="https://leetcode.com/problems/simplify-path">71. Simplify Path</a></h1>

  <p>
    Given an absolute Unix-style file path <code>path</code>, return its simplified canonical path.
    - A single period <code>"."</code> refers to the current directory.
    - A double period <code>".."</code> moves to the parent directory.
    - Multiple slashes <code>"//"</code> are treated as a single slash.
    - Directory names consist of English letters, digits, underscores, or periods :contentReference[oaicite:0]{index=0}.
  </p>

  <h2>📌 Examples</h2>
  <ul>
    <li><strong>Example 1</strong>: <code>"/home/"</code> → <code>"/home"</code></li>
    <li><strong>Example 2</strong>: <code>"/home//foo/"</code> → <code>"/home/foo"</code></li>
    <li><strong>Example 3</strong>: <code>"/home/user/Documents/../Pictures"</code> → <code>"/home/user/Pictures"</code></li>
    <li><strong>Example 4</strong>: <code>"/../"</code> → <code>"/"</code></li>
    <li><strong>Example 5</strong>: <code>"/.../a/../b/c/../d/./"</code> → <code>"/.../b/d"</code></li> :contentReference[oaicite:1]{index=1}
  </ul>

  <h2>✅ Java Solution</h2>
  <pre><code>class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        for (String ch : components) {
            ch = ch.trim();
            if (ch.equals("..")) {
                if (!st1.isEmpty()) st1.pop();
            } else if (ch.equals(".") || ch.equals("")) {
                continue;
            } else {
                st1.push(ch);
            }
        }
        while (!st1.isEmpty()) { st2.push(st1.pop()); }
        StringBuilder sb = new StringBuilder().append("/");
        while (!st2.isEmpty()) {
            sb.append(st2.pop());
            if (!st2.isEmpty()) sb.append("/");
        }
        return sb.toString();
    }
}</code></pre>

  <h2>🧠 Detailed Approach</h2>
  <ol>
    <li><strong>Split</strong> the input by <code>'/'</code> to get path components.</li>
    <li>Use a stack (<code>st1</code>) to process components:
      <ul>
        <li><code>".."?</code> → pop if stack not empty (move up one directory).</li>
        <li><code>"."</code> or empty → ignore (current directory or extra slashes).</li>
        <li>Otherwise → push component (a valid directory name).</li>
      </ul>
    </li>
    <li>After the loop, <code>st1</code> contains directories in order from root → bottom. To build path in correct order, pop into a second stack <code>st2</code>.</li>
    <li>Reconstruct simplified path: start from <code>"/"</code> and append names separated by <code>"/"</code>.</li>
    <li>If stack is empty, result is just the root <code>"/"</code>.</li>
  </ol>

  <h2>🔍 Why It Works</h2>
  <ul>
    <li>The stack efficiently handles directory traversal: pushing for descending, popping for ascending.</li>
    <li>Splitting on <code>'/'</code> handles repeated slashes naturally by producing empty strings.</li>
    <li>Two-stack reversal ensures proper order of final path reconstruction.</li>
  </ul>

  <h2>⏱️ Complexity Analysis</h2>
  <ul>
    <li><strong>Time:</strong> O(n), where n = length of <code>path</code>. Splitting, pushing, and popping each component once. :contentReference[oaicite:2]{index=2}</li>
    <li><strong>Space:</strong> O(n), for stacks and intermediate arrays.</li>
  </ul>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li>Input is just root: <code>"/"</code> → output <code>"/"</code>.</li>
    <li>Paths with multiple slashes: <code>"/a//b"</code>.</li>
    <li>Paths ending with slashes: <code>"/a/b/"</code>.</li>
    <li>Excess upward movements: <code>"/../../"</code> → remain at root <code>"/"</code>.</li>
    <li>Directory names with extra dots: <code>"/.../a"</code> → treat <code>"..."</code> as valid name. :contentReference[oaicite:3]{index=3}</li>
  </ul>

</body>
</html>
