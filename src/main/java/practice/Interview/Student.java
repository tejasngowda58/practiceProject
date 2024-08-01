package practice.Interview;

public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private Gender gender;
    private int age;
    private int grade;
    private String department;

    public Student() {
    }

    public Student(int id, String name, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Student(int id, String name, Gender gender, int age, int grade) {
        this(id, name, gender, age);
        this.grade = grade;
    }

    public Student(int id, String name, Gender gender, int age, int grade, String department) {
        this(id, name, gender, age, grade);
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
