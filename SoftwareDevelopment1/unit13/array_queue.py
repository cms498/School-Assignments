"""
An array-based implementation of a queue.

@author GCCIS Faculty
"""
import arrays

class Queue:
    __slots__ = ["__array", "__front", "__back", "__size"]

    def __init__(self, capacity=3):
        """
        Initialize the empty queue.
        """
        self.__array = arrays.Array(capacity, None)
        self.__front = 0
        self.__back = 0
        self.__size = 0

    def size(self):
        """
        Return the number of elements currently stored in the queue.
        """
        return self.__size

    def is_empty(self):
        """
        Returns True if the queue is empty, False otherwise.
        """
        return self.__size == 0

    def enqueue(self, value):
        """
        Adds a new element to the back of the queue. Resizes if the array is
        full.
        """
        if self.__size == len(self.__array):
            self.__resize()

        # add a new value to the array at back
        self.__array[self.__back] = value
        # increment back
        self.__back += 1
        if self.__back == len(self.__array):
            self.__back = 0
        # increment size
        self.__size += 1
    
    def __resize (self):
        """
        Resizes the array if it is currently full.
        """
        new_array = arrays.Array(len(self.__array) * 2 + 1)
        original_index = self.__front
        new_index = 0
        for _ in range (self.__size):
            new_array [new_index] = self.__array [original_index]
            original_index = (original_index + 1) % len(self.__array)
            new_index += 1

        self.__front = 0
        self.__back = new_index
        self.__array = new_array

    def dequeue(self):
        """
        Removes and returns the element at the front of the queue.
        """
        if self.__size == 0:
            raise IndexError("Dequeue on empty queue.")
        else:
            value = self.__array[self.__front]
            self.__array[self.__front] = None
            self.__front += 1
            if self.__front == len(self.__array):
                self.__front = 0
            self.__size -= 1
            return value

    def front(self):
        """
        Returns but does not remove the element at the front of the queue.
        """
        # check size and throw index error if 0
        if self.__size == 0:
            raise IndexError("Can't front an empty queue.")
        # return the value in the array at front
        return self.__array[self.__front]

    def back(self):
        """
        Returns but does not remove the element at the back of the queue.
        """
        # check size and throw index error if 0
        if self.__size == 0:
            raise IndexError("Can't back an empty queue.")
        # return the value in the array at front
        index = self.__back - 1
        if index < 0:
            index = len(self.__array) - 1
        return self.__array[index]

    def __repr__(self):
        """
        Returns a string representation of the queue.
        """
        if self.is_empty():
            return "[]"
        else:
            string = "[" + repr(self.__array[self.__front])
            index = (self.__front + 1) % len(self.__array)
            while index != self.__back:
                string += ", " + repr(self.__array[index])
                index = (index + 1) % len(self.__array)
            string += "]"
            return string