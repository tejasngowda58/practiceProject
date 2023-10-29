package practice.LLD.DesignPatterns.PrototypeAndRegistry;

public class IntelligentStudent extends Student{

    private int iq;

    public IntelligentStudent() {};

    public IntelligentStudent(IntelligentStudent is){
        super(is);
        this.iq = is.iq;
    }

    @Override
    public Student clone() {
        return new IntelligentStudent(this);
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
