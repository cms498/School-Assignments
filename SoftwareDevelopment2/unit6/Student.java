//import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student implements Comparable<Student>{
    private String name;
    private int id;

    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student stu = (Student)obj;
            return this.id == stu.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public String toString(){
        return name + "(" + id + ")";
    }
    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>();

        students.add(new Student("Joeseph", 1111));
        students.add(new Student("Kim", 1233));
        students.add(new Student("Joeseph", 1111));

        System.out.println(students);
    }

    @Override
    public int compareTo(Student stu) {
        return this.name.toLowerCase().compareTo(stu.name.toLowerCase());
    }
}