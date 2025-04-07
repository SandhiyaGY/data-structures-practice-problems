# [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)
## Description

<!-- description:start -->

<p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>

<p>Merge the two lists into one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>Return <em>the head of the merged linked list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0021.Merge%20Two%20Sorted%20Lists/images/merge_ex1.jpg" style="width: 662px; height: 302px;" />
<pre>
<strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>

<!-- description:end -->
## Solutions

### Approach: Iterative Two-Pointer Merge

This method merges two sorted linked lists (list1 and list2) into a single sorted linked list.

- A dummy node (result) is used to simplify edge cases and act as the starting point.

- A pointer (head) keeps track of the beginning of the merged list.

- It iterates through both lists:

- - Compares current nodes from list1 and list2.

- - Appends the smaller node to the result list.

- - Advances the pointer in the list from which the node was taken.

- After the loop, if one list is not yet finished, it appends the remaining nodes directly.

- Returns head.next, which points to the actual start of the merged list
- #### Java

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result=new ListNode(0);
        ListNode head=result;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                result.next=list1;
                list1=list1.next;
            }else{
                result.next=list2;
                list2=list2.next;
            }
            result=result.next;
        }
        if(list1!=null){
            result.next=list1;
        }else if(list2!=null){
            result.next=list2;
        }
        return head.next;
    }
}

```

