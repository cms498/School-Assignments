"""
Practice problems for units 9 - 12
Author: Chris Shepard
"""
import csv, node_stack, array_queue, random

POSSIBLE_POINTS = 50

class Exam:
    """
    Creates a blueprint for an exam object which takes in the student name taking it and the points it is out of
    """
    __slots__ = ["__name", "__possible_points", "__points_earned"]

    def __init__(self, name, possible_points):
        self.__name = name
        self.__possible_points = possible_points
        self.__points_earned = 0

    def get_name(self):
        return self.__name

    def get_possible_points(self):
        return self.__possible_points

    def get_points_earned(self):
        return self.__points_earned

    def add_earned_points(self, points):
        self.__points_earned = points

    def calculate_grade(self):
        return round((self.__points_earned / self.__possible_points) * 100, 1)

    def __repr__(self):
        return self.__name + " ("+ str(self.calculate_grade()) + ")"

    def __eq__(self, other):
        if type(self) == type(other):
            return self.__name == other.__name
        return False
    
    def __hash__(self):
        return hash(self.__name)

    def __lt__(self, other):
        if type(self) == type(other):
            if self.__name == other.__name:
                return self.__name[0] > other.__name[0]
            return self.calculate_grade() > other.calculate_grade()
        return False

def turn_in(exams):
    """
    Simulates exams being turned in on a desk, uses a stack
    """
    print("Administering exam:")
    pile = node_stack.Stack()
    for exam in exams:
        pile.push(exam)
        print("\tCompleted: " , exam)
    return pile

def grade_exams(pile):
    """
    Simulates grading the exams in a pile, uses a stack
    """
    print("Grading exams:")
    graded_pile = array_queue.Queue()
    while pile.is_empty() == False:
        exam = pile.pop()
        exam.add_earned_points(random.random() * POSSIBLE_POINTS)
        exam.calculate_grade()
        graded_pile.enqueue(exam)
        print("\tGraded: ", exam)
    return graded_pile

def enter_grades(graded_pile):
    """
    Enters students grades into a database, uses a queue
    """
    print("Entering grades into grade database")
    database = array_queue.Queue()
    while graded_pile.is_empty() == False:
        exam = graded_pile.dequeue()
        database.enqueue(exam)
        print("\tEntered: ", database.back())
    return database

def sort_grades(database):
    """
    Sort the students grades by hightest to lowest
    """
    print("Displaying sorted grades")
    list = []
    while database.is_empty() == False:
        exam = database.dequeue()
        list.append(exam)
    for exam in sorted(list):
        print("\t\b",exam)
    
def simulate_exam():
    """
    Simulates 30 students taking an exam
    """
    exam_list = []
    for i in range(1, 31):
        exam = Exam("Student #" + str(i), POSSIBLE_POINTS)
        exam_list.append(exam)
    
    pile = turn_in(exam_list)
    graded_pile = grade_exams(pile)
    database = enter_grades(graded_pile)
    sort_grades(database)

def make_street_dict():
    """
    Makes a dictionary of streets where the type is the key and the value is the name
    """
    street_dict = dict()
    with open("data/streets.csv") as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        for record in csv_reader:
            if record[1] not in street_dict:
                street_dict[record[1]] = [record[0]]
            else:
                street_dict[record[1]] += [record[0]]
    return street_dict

def main():
    """
    Calls other functions, organizational purposes
    """
    street_dict = make_street_dict()
    dr_count = 0
    red_lane = False
    vista_list = []
    for key in street_dict:
        if key == "DR":
            for _ in street_dict[key]:
                dr_count += 1
        if key == "LN":
            for street in street_dict[key]:
                if street == "RED LEAF":
                    red_lane = True
        for street in street_dict[key]:
            if street == "VISTA":
                vista_list.append(key)
    print(dr_count) #152 streets are a DR
    print(red_lane) #No there is no red leaf ln
    print(vista_list) #Only two are ["CT", "LN"]
    print()
    simulate_exam()

if __name__ == "__main__":
    main()