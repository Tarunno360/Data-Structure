class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def weiredCombination(arr, head):
    n = len(arr)
    sum_result = 0
    current = head
    i = 0

    while current:
        sum_result += arr[n - 1 - i] - current.val  # Subtract ith element of LL from n-ith element of array
        current = current.next
        i += 1

    return sum_result

# Creating the linked list: 10 -> 23 -> 30 -> 14
head = ListNode(10, ListNode(23, ListNode(30, ListNode(14))))

# Sample array
array = [15, 10, 56, 65]

# Calling the function
result = weiredCombination(array, head)
print("Result:", result)  # Expected output: 69
