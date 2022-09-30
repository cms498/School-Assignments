"""
A Student class.

@author GCCIS Faculty
"""

GRADES = ["A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F", "NG"]

QUALITY_POINTS = {
    GRADES[0]: 4.0,
    GRADES[1]: 3.67,
    GRADES[2]: 3.33,
    GRADES[3]: 3.0,
    GRADES[4]: 2.67,
    GRADES[5]: 2.33,
    GRADES[6]: 2.0,
    GRADES[7]: 1.67,
    GRADES[8]: 1.0,
    GRADES[9]: 0,
    GRADES[10]: 0 # no grade
}

class Student:
    """
    A class that represents a student with fields for ID, name, credits, and
    GPA.
    """
    __slots__ = ["__id", "__name", "__credits", "__courses"]

    def __init__(self, id, name):
        self.__id = id
        self.__name = name
        self.__credits = 0
        self.__courses = []

    def get_name(self):
        return self.__name

    def get_id(self):
        return self.__id

    def get_credits(self):
        return self.__credits

    def get_gpa(self):
        total_qps = 0
        total_credits = 0 
        for course in self.__courses:
            qp = QUALITY_POINTS[course.get_grade()]
            total_qps += qp * course.get_credits()
            total_credits += course.get_credits()
        if total_credits == 0:
            return 0
        return total_qps / total_credits

    def set_name(self, name):
        self.__name = name

    def print_student(self):
        """
        Prints a student's info to standard output.
        """
        print("Student: ID=", self.__id, ", name=", self.__name, 
            ", credits=", self.__credits, ", GPA=", self.get_gpa(), sep="")
    
    def add_course(self, course):
        self.__courses.append(course)
        self.__credits += course.get_credits()

class Course:
    __slots__ = ["__name", "__credits", "__grade"]

    def __init__(self, name, credits, grade):
        self.__name = name
        self.__credits = credits
        self.__grade = grade

    def get_name(self):
        return self.__name

    def get_credits(self):
        return self.__credits

    def get_grade(self):
        return self.__grade

    def set_grade(self, grade):
        self.__grade = grade

    def print_course(self):
        """
        Prints a course's info to standard output.
        """
        print("Course: name=", self.__name, ", credits=", self.__credits, ", grade=", self.__grade, sep="")