package Phase_1.oops;
public class student   {
    String name;
    int rollno;
    String dept;
    float cgpa;
    int age;
    public static void main(String[] args){
        student s1=new student();
        s1.name="John Doe";
        s1.rollno=12345;
        s1.dept="Computer Science";
        s1.cgpa=3.8f;
        s1.age=20;
        System.out.println("Name: " + s1.name);
        System.out.println("Roll No: " + s1.rollno);
        System.out.println("Department: " + s1.dept);
        System.out.println("CGPA: " + s1.cgpa);
        System.out.println("Age: " + s1.age);
    }
}


