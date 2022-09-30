import arrays

class Queue:
    __slots__ = ["__size", "__front", "__back", "__array"]

    def __init__(self, capacity = 5):
        self.__size = 0
        self.__front = 0
        self.__back = 0
        self.__array = arrays.Array(capacity)

    def __circular_increment(self, index):
        #return (index + 1) % len(self.__array)
        index += 1
        if index == len(self.__array):
            index = 0
        return index

    def __circular_decrement(self, index):
        return (index - 1) % len(self.__array)

    def __repr__(self):
        s = ""
        index = self.__front
        for _ in range(self.__size):
            s += ", " + repr(self.__array[index])
            index = self.__circular_increment(index)
        return "[" + s[2:] + "]"

    def size(self):
        return self.__size

    def is_empty(self):
        return self.__size == 0

    def front(self):
        if self.is_empty():
            raise IndexError("Queue is Empty")
        return self.__array[self.__front]

    def back(self):
        if self.is_empty():
            raise IndexError("Queue is Empty")
        index = self.__circular_decrement(self.__back)
        return self.__array[index]

    def __is_full(self):
        return self.__size == len(self.__array)

    def enqueue(self, value):
        if self.__is_full():
            self.__resize()
        self.__array[self.__back] = value
        self.__back = self.__circular_increment(self.__back)
        self.__size += 1

    def dequeue(self):
        if self.is_empty():
            raise IndexError("Queue is Empty")
        value = self.__array[self.__front]
        self.__front = self.__circular_increment(self.__front)
        self.__size -= 1
        return value

    def __resize(self):
        new_array = arrays.Array(len(self.__array) * 2)
        old_index = self.__front
        for new_index in range(self.__size):
            new_array[new_index] = self.__array[old_index]
            old_index = self.__circular_increment(old_index)
        self.__front = 0
        self.__back = self.__size
        self.__array = new_array

def main():
    q = Queue(2)
    print(q.size(), q.is_empty())
    print(q)
    q.enqueue("a")
    print(q)
    q.enqueue("b")
    print(q)
    q.enqueue("c")
    print(q)
    # print(q.front())
    # print(q.back())
    # print(q.dequeue(), q)
    # print(q.dequeue(), q)
    # print(q.dequeue(), q)

if __name__ == "__main__":
    main()