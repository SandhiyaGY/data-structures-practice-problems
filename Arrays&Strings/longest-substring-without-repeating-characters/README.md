<!DOCTYPE html>

<body>
    <h1>🔐 Longest Substring Without Repeating Characters</h1>
    <h2>📝 Problem Description</h2>
    <p>Given a string <code>s</code>, find the length of the longest substring without repeating characters.</p>
    <h2>📌 Example</h2>
    <ul>
        <li><strong>Input:</strong> <code>"abcabcbb"</code></li>
        <li><strong>Output:</strong> <code>3</code></li>
        <li><strong>Explanation:</strong> The answer is <code>"abc"</code>, with the length of 3.</li>
    </ul>
    <h2>💡 Approach</h2>
    <p>This is a brute-force approach using nested loops to check every possible substring.</p>
    <ol>
        <li>Iterate over each character in the string using index <code>i</code>.</li>
        <li>From each starting index <code>i</code>, extend the substring using another loop with index <code>j</code>.</li>
        <li>Use a <code>HashSet</code> to keep track of characters in the current substring.</li>
        <li>If a duplicate character is found, break the inner loop.</li>
        <li>Update the maximum length found so far using <code>Math.max()</code>.</li>
        <li>Return the longest length at the end.</li>
    </ol>
    <p><strong>Note:</strong> This solution has a time complexity of <code>O(n<sup>2</sup>)</code> and space complexity of <code>O(min(n, m))</code> where <code>n</code> is the length of the string and <code>m</code> is the size of the character set.</p>
    <h2>✅ Java Solution</h2>
    <pre><code>import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int larLen = 0;
        for (int i = 0; i &lt; s.length(); i++) {
            HashSet&lt;Character&gt; h = new HashSet&lt;&gt;();
            for (int j = i; j &lt; s.length(); j++) {
                char ch = s.charAt(j);
                if (h.contains(ch)) {
                    break;
                }
                h.add(ch);
                larLen = Math.max(larLen, j - i + 1);
            }
        }
        return larLen;
    }
}</code></pre>
</body>
</html>
