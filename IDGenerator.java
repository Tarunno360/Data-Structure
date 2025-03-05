class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IDGenerator {

    public static Node idGenerator(Node list1, Node list2, Node list3) {
        if (list1 == null || list2 == null || list3 == null) {
            return null; // Handle null lists
        }

        Node idHead = null; // Head of the generated ID list
        Node idTail = null; // Tail of the generated ID list

        // 1. Reverse the first linked list and add to the ID
        Node reversedList1 = reverseList(list1);
        Node current = reversedList1;
        int count = 0;
        while (current != null && count < 4) {
            append(current.data, idHead, idTail);
            if (idHead == null) {
                idHead = current;
                idTail = current;
            } else {
                idTail.next = current;
                idTail = current;
            }
            current = current.next;
            count++;
        }

        // 2. Add elements from list2 and list3 (modulo 10 if needed)
        Node current2 = list2;
        Node current3 = list3;
        count = 0;
        while (current2 != null && current3 != null && count < 4) {
            int sum = current2.data + current3.data;
            int digit = sum >= 10 ? sum % 10 : sum;
            append(digit, idHead, idTail);
            if(idHead == null){
                idHead = new Node(digit);
                idTail = idHead;
            } else {
                idTail.next = new Node(digit);
                idTail = idTail.next;
            }

            current2 = current2.next;
            current3 = current3.next;
            count++;
        }

        return idHead;
    }

    // Helper method to reverse a linked list
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Helper method to append a digit to the ID list
    public static void append(int data, Node idHead, Node idTail) {
        Node newNode = new Node(data);

        if (idHead == null) {
            idHead = newNode;
            idTail = newNode;
        } else {
            idTail.next = newNode;
            idTail = newNode;
        }
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
        // Sample Input 1
        Node list1_1 = createList(new int[]{0, 3, 2, 2});
        Node list2_1 = createList(new int[]{5, 2, 2, 1});
        Node list3_1 = createList(new int[]{4, 3, 2, 1});
        Node id1 = idGenerator(list1_1, list2_1, list3_1);
        printList(id1); // Output: 2 -> 2 -> 3 -> 0 -> 9 -> 5 -> 4 -> 2 -> None

        // Sample Input 2
        Node list1_2 = createList(new int[]{0, 3, 9, 1});
        Node list2_2 = createList(new int[]{3, 6, 5, 7});
        Node list3_2 = createList(new int[]{2, 4, 3, 8});
        Node id2 = idGenerator(list1_2, list2_2, list3_2);
        printList(id2); // Output: 1 -> 9 -> 3 -> 0 -> 5 -> 0 -> 8 -> 5 -> None
    }

    // Helper method to create a linked list from an array
    public static Node createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        return head;
    }
}
