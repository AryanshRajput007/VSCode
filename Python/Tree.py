class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def inorder_recursive(root):
    if root:
        inorder_recursive(root.left)
        print(root.data, end=' ')
        inorder_recursive(root.right)

def preorder_recursive(root):
    if root:
        print(root.data, end=' ')
        preorder_recursive(root.left)
        preorder_recursive(root.right)

def postorder_recursive(root):
    if root:
        postorder_recursive(root.left)
        postorder_recursive(root.right)
        print(root.data, end=' ')

def preorder_iterative(root):
    if not root:
        return []
    
    stack = [root]
    result = []

    while stack:
        current = stack.pop()
        result.append(current.data)

        if current.right:
            stack.append(current.right)
        if current.left:
            stack.append(current.left)

    return result

def inorder_iterative(root):
    result = []
    stack = []
    current = root

    while True:
        while current:
            stack.append(current)
            current = current.left

        if not stack:
            break

        current = stack.pop()
        result.append(current.data)
        current = current.right

    return result

if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)

    print("Inorder (recursive):")
    inorder_recursive(root)
    print("\nInorder (iterative):")
    result = inorder_iterative(root)
    print(result)

    print("\nPreorder (recursive):")
    preorder_recursive(root)

    print("\nPreorder (iterative):")
    result2 = preorder_iterative(root)
    print(result2)
