import node

class Stack:
    __slots__ = ["__top", "__size"]

    def __init__(self):
        self.__top = None
        self.__size = 0

    def size(self):
        return self.__size

    def is_empty(self):
        return self.__size == 0

    def __stringify(self, node):
        if node == None:
            return ""
        return self.__stringify(node.get_next()) + ", " + repr(node.get_value())

    def __repr__(self):
        return "[" + self.__stringify(self.__top)[2:] + "]"

    def push(self, value):
        new_node = node.Node(value, self.__top)
        self.__top = new_node
        self.__size += 1

    def peek(self):
        if self.__top == None:
            return None
        return self.__top.get_value()

    def pop(self):
        if self.__top == None:
            return None
        current_top = self.__top.get_value()
        self.__top = self.__top.get_next()
        self.__size -= 1
        return current_top

def main():
    a_stack = Stack()
    print(a_stack.peek())
    print(a_stack.size(), a_stack.is_empty())
    print(a_stack)
    a_stack.push("c")
    print(a_stack)
    a_stack.push("b")
    print(a_stack)
    a_stack.push("a")
    print(a_stack)
    print(a_stack.peek())
    print(a_stack.pop(), a_stack)
    print(a_stack.pop(), a_stack)
    print(a_stack.pop(), a_stack)
    print(a_stack.pop(), a_stack)

if __name__ == "__main__":
    main()