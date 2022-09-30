package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString(){
        return this.lastName + ", " + this.firstName;
    }

    @Override
    public int compareTo(Student other) {
        return this.getFirstName().compareTo(other.getFirstName());
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Chris", "Shepard"));
        students.add(new Student("Sam", "Frost"));
        students.add(new Student("Ari", "Becker"));
        students.add(new Student("Alec", "Haag"));

        System.out.println("Before Sort = " + students);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.toString().compareTo(s2.toString());
            }
        });

        System.out.println("After Sort = " + students);

        // Comparator<Student> c = (Student s1, Student s2) -> {
        //     return s2.getLastName().compareTo(s1.getLastName());
        // };

        // Collections.sort(students, (Student s1, Student s2) -> {
        //          return s2.getLastName().compareTo(s1.getLastName());
        // });

        // Collections.sort(students, (s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName()));

        students.sort(Student::compareTo);

        System.out.println("After Reverse Sort = " + students);

        Consumer<Student> consumer = new Consumer<Student>() {
            @Override
            public void accept(Student student){
                System.out.println(student.getFirstName() + ", " + student.getLastName());
            }
        };

        Stream<Student> stream = students.stream();
        stream.forEach(consumer);

        // or

        //students.stream().forEach(student -> System.out.println(student.getFirstName() + ", " + student.getLastName()));

        students.stream().filter(student -> student.getFirstName().toLowerCase().contains("s") 
        || student.getLastName().toLowerCase().contains("s"))
        .forEach(student -> System.out.println(student.getFirstName() + ", " + student.getLastName()));;
    }
}