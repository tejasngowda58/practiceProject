package practice.LLD.DesignPatterns.Builder;

public class Builder {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String emailId;
    private String city;
    private int gradYear;
    private float psp;
    private String batch;

    public Student build(){
        return new Student(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public Builder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Builder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Builder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public Builder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Builder setCity(String city) {
        this.city = city;
        return this;
    }

    public int getGradYear() {
        return gradYear;
    }

    public Builder setGradYear(int gradYear) {
        this.gradYear = gradYear;
        return this;
    }

    public float getPsp() {
        return psp;
    }

    public Builder setPsp(float psp) {
        this.psp = psp;
        return this;
    }

    public String getBatch() {
        return batch;
    }

    public Builder setBatch(String batch) {
        this.batch = batch;
        return this;
    }

}
