package practice.LLD.DesignPatterns.Builder;

import java.io.IOException;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String emailId;
    private String city;
    private int gradYear;
    private float psp;
    private String batch;

    public Student() {}

    public Student(Builder builder) throws IOException {
        if (builder.getAge()>100)
            throw new IOException("Invalid age");
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.age= builder.getAge();;
        this.gradYear= builder.getGradYear();
        this.emailId = builder.getEmailId();
        this.city = builder.getCity();
    }
    public Student(String firstName, String lastName, int age, String phoneNumber, String emailId, String city, int gradYear, float psp, String batch) throws IOException {
        if (age>100)
            throw new IOException("Invalid age");

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.city = city;
        this.gradYear = gradYear;
        this.psp = psp;
        this.batch = batch;
    }

    public static Builder getBuilder(){
        return new Builder();
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getCity() {
        return city;
    }

    public int getGradYear() {
        return gradYear;
    }

    public float getPsp() {
        return psp;
    }

    public String getBatch() {
        return batch;
    }
}
