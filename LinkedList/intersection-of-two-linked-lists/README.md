# [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists)

## Description

<!-- description:start -->

<p>Given the heads of two singly linked-lists <code>headA</code> and <code>headB</code>, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return <code>null</code>.</p>

<p>The test cases are generated such that there are no cycles anywhere in the entire linked structure.</p>

<p><strong>Note:</strong> The linked lists must retain their original structure after the function returns.</p>

<p><strong>Custom Judge:</strong></p>
<ul>
  <li><code>intersectVal</code> - The value of the node where the intersection occurs. This is <code>0</code> if there is no intersected node.</li>
  <li><code>listA</code> - The first linked list.</li>
  <li><code>listB</code> - The second linked list.</li>
  <li><code>skipA</code> - The number of nodes to skip ahead in <code>listA</code> to get to the intersected node.</li>
  <li><code>skipB</code> - The number of nodes to skip ahead in <code>listB</code> to get to the intersected node.</li>
</ul>

<!-- description:end -->

---

## Examples

### Example 1:
<img alt="example1" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_1_1.png" style="width: 600px;" />
<pre>
<strong>Input:</strong> intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
<strong>Output:</strong> Intersected at '8'
<strong>Explanation:</strong> The intersected node's value is 8. From the head of A it reads as [4,1,<u>8,4,5</u>]. 
From the head of B it reads as [5,6,1,<u>8,4,5</u>].
</pre>

### Example 2:
<img alt="example2" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_2.png" style="width: 600px;" />
<pre>
<strong>Input:</strong> intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
<strong>Output:</strong> Intersected at '2'
</pre>

### Example 3:
<img alt="example3" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_3.png" style="width: 300px;" />
<pre>
<strong>Input:</strong> intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
<strong>Output:</strong> No intersection
</pre>

---

## Constraints

- The number of nodes of `listA` is in the range `[1, 3 * 10⁴]`.
- The number of nodes of `listB` is in the range `[1, 3 * 10⁴]`.
- `1 <= Node.val <= 10⁵`
- `0 <= skipA <= listA.length`
- `0 <= skipB <= listB.length`
- `intersectVal` is `0` if `listA` and `listB` do not intersect.
- `intersectVal == listA[skipA] == listB[skipB]` if `listA` and `listB` intersect.

---

## Solutions

### Approach: Two Pointer Technique

- Use two pointers: `pA` starting at `headA` and `pB` at `headB`.
- Traverse each list. When a pointer reaches the end of its list, redirect it to the head of the other list.
- They will either meet at the intersection node or both reach `null` (no intersection).
- Ensures each pointer travels exactly `lengthA + lengthB`.

---

### Java

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null ||headB==null){
            return null;
        }
        ListNode ptrA=headA;
        ListNode ptrB=headB;
        while(ptrA!=ptrB){
            ptrA=(ptrA==null)?headB:ptrA.next;
            ptrB=(ptrB==null)?headA:ptrB.next;
        }
        return ptrA;
    }
}
