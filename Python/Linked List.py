class SingleNode:
    def __init__(self, data):
        self.data = data
        self.next = None
        
class DoubleNode:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None
        
class SinglyLinkedList:
    def __init__(self):
        self.head = None
        
    def insertAtBegin(self, data):
        newnode = SingleNode(data)
        if(self.head == None):
            head = newnode
        newnode.next = self.head
        self.head = newnode
    
    def insertAtEnd(self, data):
        newnode = SingleNode(data)
        if(self.head == None):
            head = newnode
        current = self.head
        while(current.next != None):
            current = current.next
        current.next = newnode
    
    def insertAtIndex(self, data, index):
        newnode = SingleNode(data)
        if(index < 0):
            print("The Index value cannot be negative!")
        if(index == 0):
            newnode.next = self.head
            self.head = newnode
        temp = 0
        current = self.head
        while(current.next != None and temp < index):
            current = current.next
            temp += 1
        if(current != None):
            newnode.next = current.next
            current.next = newnode
        else:
            print("Error detected! Index out of Bound")
    

if __name__ == "__main__":
    head = SinglyLinkedList(10)
    
    
    