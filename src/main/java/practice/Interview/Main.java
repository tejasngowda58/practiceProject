package practice.Interview;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class Main {
    public static void main(String[] args) {
//        printStudentByMaxAge();
//        duplicateValues();
//        printStudentByMaxGrade();
        groupByGender();
        incrementAgeBy10AndPrintAgeGreaterThan35();

        System.out.print("equalityCheck is: ");
        equalityCheck();

        test1();
    }

    public static List<Student> generateStudentsList() {
        Student student1 = new Student(1, "Tejas", Gender.Male, 30, 85, "TCE");
        Student student2 = new Student(2, "Uday", Gender.Male, 27, 89, "MECH");
        Student student3 = new Student(3, "Nisarga", Gender.Female, 28, 95, "CIVIL");
        Student student4 = new Student(4, "Sihi", Gender.Female, 21, 94, "CIVIL");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        return studentList;
    }

    /**
     * * Get Student by max age
     */
    public static void printStudentByMaxAge(){
        Student student1 = new Student(1, "Tejas", Gender.Male, 30);
        Student student2 = new Student(2, "Uday", Gender.Male, 27);
        Student student3 = new Student(3, "Nisarga", Gender.Female, 28);
        Student student4 = new Student(4, "Sihi", Gender.Female, 21);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        Optional<Student> max = studentList.stream().max(Comparator.naturalOrder());
        if (max.isPresent())
            System.out.println("Student with max age is :" + max.get().getName());
    }
    
    public static void printStudentByMaxGrade(){
        Student student1 = new Student(1, "Tejas", Gender.Male, 30, 85);
        Student student2 = new Student(2, "Uday", Gender.Male, 27, 89);
        Student student3 = new Student(3, "Nisarga", Gender.Female, 28, 95);
        Student student4 = new Student(4, "Sihi", Gender.Female, 21, 94);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        Optional<Student> max = studentList.stream().max(Comparator.comparing(Student::getGrade));

        if (max.isPresent())
            System.out.println("Student with max grade is :" + max.get().getName());
    }

    /**
     * * Get Student by max age
     */
    public static void printStudentByMaxAgeGroupedByGender(){
        Student student1 = new Student(1, "Tejas", Gender.Male, 30);
        Student student2 = new Student(2, "Uday", Gender.Male, 27);
        Student student3 = new Student(3, "Nisarga", Gender.Female, 28);
        Student student4 = new Student(4, "Sihi", Gender.Female, 21);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        Optional<Student> max = studentList.stream().max(Comparator.naturalOrder());
        if (max.isPresent())
            System.out.println(max.get().getName());
    }

    /**
     * * Create array list with duplicate values
     */
    public static void duplicateValues(){
        Student student1 = new Student(1, "tejas", Gender.Male, 30);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student1);
        Collections.sort(students);
        for (Student s: students){
            System.out.println(s.getName());
        }
    }

    public static void groupByGender(){
        List<Student> students = generateStudentsList();

        Map<Gender, List<Student>> collect = students.stream().collect(groupingBy(Student::getGender));
        System.out.println(collect);

        Map<Gender, Optional<Student>> collect1 = students.stream().collect(groupingBy(Student::getGender, maxBy(Comparator.comparing(Student::getGender))));

        for (var entry: collect1.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().get());
        }

    }

    public static void incrementAgeBy10AndPrintAgeGreaterThan35(){
        List<Student> students = generateStudentsList();
        List<String> studentsWithAgeGT30 = students
                .stream()
                .map(student -> new Student(student.getId(), student.getName(), student.getGender(), student.getAge() + 2))
                .filter(s -> s.getAge() > 30)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println(studentsWithAgeGT30.size());
        System.out.println(studentsWithAgeGT30);
    }

    public static void equalityCheck(){
        Student student1 = new Student(1, "Tejas", Gender.Male, 30, 85);
        Student student2 = new Student(1, "Tejas", Gender.Male, 30, 85);
        System.out.println(student1.equals(student2));
    }

    public static void equalityCheck1(){
        String abc = "abc";

    }

    public static void test1(){
        // student with max age;

        List<Student> students = generateStudentsList();

        Optional<Student> studentOptional = students.stream().max(Comparator.naturalOrder());

        Optional<Student> studentOptional1 = students.stream().min(Comparator.naturalOrder());

        Map<Gender, List<Student>> studentListMap = students.stream().collect(Collectors.groupingBy(Student::getGender));

        Map<Gender, Optional<Student>> genderListMap1 = students.stream().collect(groupingBy(Student::getGender, maxBy(Comparator.comparing(Student::getAge))));

        //students name starting with N
        List<Student> collect = students.stream().filter(student -> student.getName().startsWith("N")).collect(Collectors.toList());
        System.out.println(collect);

        // max age of a student
        OptionalInt max = students.stream().mapToInt(m -> m.getAge()).max();

        //students name starting with N
        List<Student> t = students.stream().filter(student -> student.getName().startsWith("T")).collect(Collectors.toList());

        // total count
        long count = students.stream().count();

        // max age of student
        OptionalInt max1 = students.stream().mapToInt(student -> student.getAge()).max();

        //Find all depts.
        List<String> depts = students.stream().map(student -> student.getDepartment()).distinct().collect(Collectors.toList());

//      Find the count of student in each department
        Map<String, Long> studentCountByDept = students.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));

//      Find the average age of male and female students

        Map<Gender, Double> avgAgeByGender = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

//      Find the department who is having maximum number of students

        Optional<Map.Entry<String, Long>> max2 = students.stream().collect(groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

//      Find the highest rank in each department

        students.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.maxBy(Comparator.comparing(Student::getAge))));

    }

}
