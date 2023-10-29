package practice.LLD.DesignPatterns.Builder;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        Student student = null;

        /**
         * Using builder and passing it as a parameter to Student constructor.
         *         Builder builder = new Builder();
         *         builder.setFirstName("tejas");
         *         builder.setLastName("nagaraj");
         *         builder.setAge(29);
         *         student = new Student(builder);
         */

        /**
         *  Instead of creating a Builder and then setting the values and then passing
         *  it to the student constructor, do these all things in a single line as given below
         */

        student = Student.getBuilder().setFirstName("Tejas").setLastName("Nagaraj").setAge(29).
                setCity("Bangalore").setBatch("Aug2022_B2").build();

        /**
         * Creating Student usiong all args constructor which is tedious due to remembering the
         * name of the parameters available
         *
         *            student = new Student("tejas", "nagaraj", 29, "+919880081162",
         *                     "tej@gmail.com", "Bangalore", 2016, 90.0f, "AUG_B2");
         */

        if (student==null){
            System.out.println("No student available");
        }
        else {
            System.out.println("Student with name" + student.getFirstName() + " created");
            System.out.println(student.getFirstName());
        }

        System.out.println("DEBUG");
    }

}
