class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class WeirdCombination {

    public static int weiredCombination(int[] arr, ListNode head) {
        int n = arr.length;
        int sumResult = 0;
        ListNode current = head;
        int i = 0;

        while (current != null) {
            sumResult += arr[n - 1 - i] - current.val;
            current = current.next;
            i++;
        }

        return sumResult;
    }

    public static void main(String[] args) {
        // Creating the linked list: 10 -> 23 -> 30 -> 14
        ListNode head = new ListNode(10, new ListNode(23, new ListNode(30, new ListNode(14))));

        // Sample array
        int[] array = {15, 10, 56, 65};

        // Calling the function
        int result = weiredCombination(array, head);
        System.out.println("Result: " + result); // Expected output: 69
    }
}
