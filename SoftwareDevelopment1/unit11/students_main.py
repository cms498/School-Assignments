import students

def main():
    me = students.Student("A123", "Chris")
    me.print_student()

    gcis123 = students.Course("GCIS-123", 4, "A")
    itds140 = students.Course("ITDS-140", 3, "A")
    iste140 = students.Course("ISTE-140", 3, "D")

    gcis123.print_course()
    itds140.print_course()
    iste140.print_course()

    me.add_course(gcis123)
    me.add_course(itds140)
    me.add_course(iste140)

    me.print_student()

    iste140.set_grade("A")
    
    me.print_student()

if __name__ == "__main__":
    main()