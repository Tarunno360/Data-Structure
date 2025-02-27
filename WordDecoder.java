class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class WordDecoder {

    public static Node decode(Node head) {
        if (head == null) {
            return null;
        }

        // 1. Calculate the length of the linked list
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // 2. Calculate the decoding step
        int step = 13 % length;

        // 3. Extract characters at multiples of the step
        StringBuilder decodedWord = new StringBuilder();
        current = head;
        for (int i = 0; current != null; i++) {
            if (i % step == 0 && i != 0) { // Start from the first multiple after 0
                decodedWord.append(current.data);
            }
            current = current.next;
        }

        // 4. Reverse the extracted characters
        decodedWord.reverse();

        // 5. Create a new linked list with the decoded word
        Node dummyHead = new Node('\0'); // Dummy head
        Node tail = dummyHead;
        for (int i = 0; i < decodedWord.length(); i++) {
            tail.next = new Node(decodedWord.charAt(i));
            tail = tail.next;
        }

        return dummyHead.next; // Return the actual head (after the dummy)
    }

    // Helper method to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }

    public static void main(String[] args) {
        // Example 1: B -> M -> D -> T -> N -> O -> A -> P -> S -> C
        Node head1 = new Node('B');
        head1.next = new Node('M');
        head1.next.next = new Node('D');
        head1.next.next.next = new Node('T');
        head1.next.next.next.next = new Node('N');
        head1.next.next.next.next.next = new Node('O');
        head1.next.next.next.next.next.next = new Node('A');
        head1.next.next.next.next.next.next.next = new Node('P');
        head1.next.next.next.next.next.next.next.next = new Node('S');
        head1.next.next.next.next.next.next.next.next.next = new Node('C');

        Node decodedHead1 = decode(head1);
        printList(decodedHead1); // Output: C -> A -> T -> None

        // Example 2: Z -> O -> T -> N -> X
        Node head2 = new Node('Z');
        head2.next = new Node('O');
        head2.next.next = new Node('T');
        head2.next.next.next = new Node('N');
        head2.next.next.next.next = new Node('X');

        Node decodedHead2 = decode(head2);
        printList(decodedHead2); // Output: N -> None
    }
}
