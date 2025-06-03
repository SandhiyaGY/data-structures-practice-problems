<h1>🧮 Singly Linked List in Java</h1>

<p>This is a simple implementation of a singly linked list (SLL) in Java that supports three main operations:</p>

<ul>
  <li><strong>Append</strong> a node</li>
  <li><strong>Delete</strong> a node by value</li>
  <li><strong>Display</strong> the list</li>
</ul>

<h2>📦 How to Run</h2>

<ol>
  <li>Compile the program:<br>
  <code>javac Main.java</code></li>

  <li>Run the program:<br>
  <code>java Main</code></li>
</ol>

<h2>💻 Input Format</h2>

<p>The program accepts user input from the console in the following format:</p>

<table border="1">
  <tr>
    <th>Command</th>
    <th>Description</th>
    <th>Example</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Append number to list</td>
    <td>1 42</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Delete number from list</td>
    <td>2 42</td>
  </tr>
  <tr>
    <td>Any other number</td>
    <td>Display list contents</td>
    <td>3</td>
  </tr>
</table>

<h2>🧪 Example</h2>

<pre>
Input:
1 10
1 20
2 10
3

Output:
20
</pre>

<h2>🧾 Full Code</h2>

<pre><code class="language-java">
import java.util.Scanner;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {
    Node head;
    Node last;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            return;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp != null) {
                if (temp.data == data) {
                    prev.next = temp.next;
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL ll = new SLL();
        while (sc.hasNext()) {
            int choice = sc.nextInt();
            if (choice == 1) {
                int num = sc.nextInt();
                ll.append(num);
            } else if (choice == 2) {
                int num = sc.nextInt();
                ll.delete(num);
            } else {
                ll.display();
            }
        }
    }
}
</code></pre>
