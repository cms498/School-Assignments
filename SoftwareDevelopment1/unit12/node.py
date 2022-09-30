class Node:
    __slots__ = ["__value", "__next"]

    def __init__(self, value, next = None):
        self.__value = value
        self.__next = next

    def get_value(self):
        return self.__value

    def get_next(self):
        return self.__next

def print_node(node_seq):
    if node_seq == None:
        print()
        return
    print(node_seq.get_value(),", " , sep="", end="")
    print_node(node_seq.get_next())

def main():
    a_node = Node("a")
    print(a_node.get_value(), a_node.get_next())
    b_node = Node("b", a_node)
    c_node = Node("c", b_node)

    print_node(c_node)

if __name__ == "__main__":
    main()