
<body>
  <h1>🔎 LeetCode 242: Valid Anagram</h1>

  <h2>📝 Description</h2>
  <p>
    Given two strings <code>s</code> and <code>t</code>, determine whether <code>t</code> is an anagram of <code>s</code>.  
    An anagram is a word or phrase formed by rearranging the letters of another, using all the original letters exactly once. 
  </p>

  <h2>📊 Example</h2>
  <pre><code>Input:  s = "anagram", t = "nagaram"
Output: true

Input:  s = "rat", t = "car"
Output: false</code></pre>

  <h2>🧠 Approach (HashMap Frequency Counting)</h2>
  <ol>
    <li>If <code>s</code> and <code>t</code> have different lengths, they cannot be anagrams.<br>  
      <em>Time complexity</em>: O(n + m) — lengths of <code>s</code> and <code>t</code> 
    </li>
    <li>Create a <code>HashMap&lt;Character, Integer&gt;</code> to count frequency of each character in <code>s</code>. </li>
    <li>Traverse <code>t</code>, decrementing the count for each character:<br>
      - If a character is missing or count goes below zero → return <code>false</code>.</li>
    <li>If all characters in <code>t</code> are matched, return <code>true</code>.</li>
  </ol>

  <div class="note">
    ✅ This runs in <strong>O(n)</strong> time and uses O(k) auxiliary space, where k is unique character count.
  </div>

  <h2>📄 Solution (Java)</h2>
  <pre><code>class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    HashMap<Character, Integer> h = new HashMap<>();
    for (char ch : s.toCharArray()) {
      h.put(ch, h.getOrDefault(ch, 0) + 1);
    }
    for (char ch : t.toCharArray()) {
      if (!h.containsKey(ch) || h.get(ch) == 0) {
        return false;
      }
      h.put(ch, h.get(ch) - 1);
    }
    return true;
  }
}</code></pre>

  <h2>⏱️ Complexity</h2>
  <ul>
    <li><strong>Time:</strong> O(n), where n = length of <code>s</code> (same as <code>t</code>)</li>
    <li><strong>Space:</strong> O(k), for storing character counts (up to alphabet size) </li>
  </ul>

  <h2>📚 References</h2>
  <ul>
    <li>GeeksforGeeks: Anagram check using HashMap</li>
    <li>Medium article: frequency counting approach & tradeoffs </li>
    <li>StackOverflow discussion on space complexity and hash map bounds </li>
  </ul>
</body>
</html>
