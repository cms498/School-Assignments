"""
This program prints out messages to the user
Author: Chris Shepard
"""


def hello_world():
    '''
    Prints "Hello, World" but in a function
    '''
    print("Hello, World!")#outputs a string of Hello World

def hello_you():
    '''
    Asks the user for their name and says hello
    '''
    name = input("Enter your name: ")#name input
    print("Hello, " , name, "!", sep="")#prints the personalized message


hello_world()#calls the hello_world function
hello_you()#calls the hello_you function