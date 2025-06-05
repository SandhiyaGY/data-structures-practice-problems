<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
</head>
<body>

<h1><a href="https://leetcode.com/problems/lru-cache/description/" target="_blank">146. LRU Cache</a></h1>
<p>Design a data structure that follows the constraints of a <strong>Least Recently Used (LRU)</strong> cache.</p>

<p>Implement the <code>LRUCache</code> class:</p>
<ul>
  <li><code>LRUCache(int capacity)</code> - Initialize the LRU cache with positive size <code>capacity</code>.</li>
  <li><code>int get(int key)</code> - Return the value of the <code>key</code> if the key exists, otherwise return <code>-1</code>.</li>
  <li><code>void put(int key, int value)</code> - Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the <code>capacity</code>, evict the least recently used key.</li>
</ul>

<p>Both functions <code>get</code> and <code>put</code> must run in <strong>O(1)</strong> average time complexity.</p>

<hr>

<h2>📷 Example</h2>

<pre>
Input:
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output:
[null, null, null, 1, null, -1, null, -1, 3, 4]
</pre>

<p><strong>Explanation:</strong></p>

<pre>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
</pre>

<hr>

<h2>📌 Constraints</h2>
<ul>
  <li><code>1 <= capacity <= 3000</code></li>
  <li><code>0 <= key <= 10⁴</code></li>
  <li><code>0 <= value <= 10⁵</code></li>
  <li>At most <code>2 * 10⁵</code> calls will be made to <code>get</code> and <code>put</code></li>
</ul>

<hr>

<h2>💡 Approach</h2>
<p>We extend <code>LinkedHashMap</code> with accessOrder = true. This allows the map to maintain the access order instead of insertion order.</p>

<ul>
  <li>We override <code>removeEldestEntry()</code> to remove the least recently used item when the size exceeds capacity.</li>
  <li><code>get()</code> accesses the key, moving it to the end (most recently used).</li>
  <li><code>put()</code> inserts or updates the key and moves it to the end.</li>
</ul>

<hr>

<h2>🧾 Java Code</h2>

```java
class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
```

<hr>

<h2>⏱️ Complexity Analysis</h2>
<ul>
  <li><strong>Time Complexity:</strong> O(1) for both <code>get()</code> and <code>put()</code></li>
  <li><strong>Space Complexity:</strong> O(capacity)</li>
</ul>

<hr>

<h2>🧠 Key Takeaways</h2>
<ul>
  <li><code>LinkedHashMap</code> with access order provides a built-in way to implement LRU caching.</li>
  <li>Use <code>removeEldestEntry</code> to auto-evict LRU items when size exceeds capacity.</li>
  <li>Ensures both operations are O(1) on average.</li>
</ul>

</body>
</html>
