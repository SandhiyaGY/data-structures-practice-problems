<!DOCTYPE html>
<html lang="en">

<body>
    <h1>🔁 Group Anagrams</h1>
    <h2>📝 Problem Description</h2>
    <p>Given an array of strings <code>strs</code>, group the anagrams together. You can return the answer in any order.</p>
    <p>Two strings are anagrams of each other if their characters can be rearranged to form the other string.</p>
    <h2>📌 Example</h2>
    <ul>
        <li><strong>Input:</strong> <code>["eat","tea","tan","ate","nat","bat"]</code></li>
        <li><strong>Output:</strong> <code>[["eat","tea","ate"],["tan","nat"],["bat"]]</code></li>
    </ul>
    <h2>💡 Approach</h2>
    <p>We use a <code>HashMap</code> to group anagrams using a sorted version of each string as the key.</p>
    <ol>
        <li>Initialize a map where key = sorted string, value = list of original strings.</li>
        <li>For each string in the array:
            <ul>
                <li>Convert the string to a character array and sort it.</li>
                <li>Use the sorted string as the key.</li>
                <li>Add the original string to the list corresponding to the sorted key in the map.</li>
            </ul>
        </li>
        <li>Return all values (grouped lists) from the map.</li>
    </ol>
    <p><strong>Time Complexity:</strong> <code>O(n * k log k)</code>, where <code>n</code> is the number of strings and <code>k</code> is the maximum length of a string.</p>
    <p><strong>Space Complexity:</strong> <code>O(n * k)</code> to store the result.</p>
    <h2>✅ Java Solution</h2>
    <pre><code>import java.util.*;
class Solution {
    public List&lt;List&lt;String&gt;&gt; groupAnagrams(String[] strs) {
        Map&lt;String, List&lt;String&gt;&gt; map = new HashMap&lt;&gt;();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.putIfAbsent(key, new ArrayList&lt;&gt;());
            map.get(key).add(str);
        }
        return new ArrayList&lt;&gt;(map.values());
    }
}</code></pre>
</body>
</html>
