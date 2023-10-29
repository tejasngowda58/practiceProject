package practice.LLD.DesignPatterns.PrototypeAndRegistry;

public class Student implements Prototype<Student>{

    private String name;
    private int age;
    private float psp;
    private String batch;
    private float averageBatchPsp;
    private String internalState;

    public Student() {};

    public Student(Student st){
        this.name = st.name;
        this.age = st.age;
        this.psp = st.psp;
        this.batch = st.batch;
        this.averageBatchPsp = st.averageBatchPsp;
        this.internalState = st.internalState;
    }

    @Override
    public Student clone() {
        return new Student(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getPsp() {
        return psp;
    }

    public void setPsp(float psp) {
        this.psp = psp;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public float getAverageBatchPsp() {
        return averageBatchPsp;
    }

    public void setAverageBatchPsp(float averageBatchPsp) {
        this.averageBatchPsp = averageBatchPsp;
    }
}
