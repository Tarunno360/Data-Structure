class Node:
    def __init__(self, value):
        self.val = value
        self.next = None
        self.prev = None

def rearrange_linked_list(head):
    if not head:
        return None
    
    odd_head = odd_tail = None
    even_head = even_tail = None
    current = head
    
    # Traverse the list and separate odd and even nodes
    while current:
        if current.val % 2 != 0:  # Odd node
            if not odd_head:
                odd_head = odd_tail = current
            else:
                odd_tail.next = current
                current.prev = odd_tail
                odd_tail = current
        else:  # Even node
            if not even_head:
                even_head = even_tail = current
            else:
                even_tail.next = current
                current.prev = even_tail
                even_tail = current
        
        current = current.next
    
    # Connect odd list with even list
    if odd_tail:
        odd_tail.next = even_head
    if even_head:
        even_head.prev = odd_tail
    
    # The new head is the start of the odd list
    return odd_head

# Helper function to print the list
def print_list(head):
    current = head
    while current:
        print(current.val, end=" <-> ")
        current = current.next
    print("None")

# Helper function to create a doubly linked list
def create_linked_list(arr):
    if not arr:
        return None
    head = Node(arr[0])
    current = head
    for value in arr[1:]:
        new_node = Node(value)
        current.next = new_node
        new_node.prev = current
        current = new_node
    return head

# Test the function
arr = [1, 2, 3, 4, 5, 6, 7, 8]
head = create_linked_list(arr)
print("Original list:")
print_list(head)

head = rearrange_linked_list(head)

print("\nRearranged list:")
print_list(head)
