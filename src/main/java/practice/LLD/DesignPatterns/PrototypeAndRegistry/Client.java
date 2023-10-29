package practice.LLD.DesignPatterns.PrototypeAndRegistry;

public class Client {

    static String AUG_B1 = "AUG_B1";
    static String SEPT_B2 = "SEPT_B2";

    public static StudentRegistry getRegistry(){
        StudentRegistry studentRegistry = new StudentRegistry();
        Student student = new Student();
        student.setBatch("AUG_B1");
        student.setAverageBatchPsp(82.0f);
        studentRegistry.register(AUG_B1, student);

        IntelligentStudent intelligentStudent = new IntelligentStudent();
        intelligentStudent.setBatch(SEPT_B2);
        intelligentStudent.setAverageBatchPsp(92.0f);
        studentRegistry.register(SEPT_B2, intelligentStudent);

        return studentRegistry;
    }

    public static void main(String[] args) {
        StudentRegistry studentRegistry = getRegistry();
        Student student = getRegistry().get(AUG_B1).clone();
        IntelligentStudent intelligentStudent = (IntelligentStudent) getRegistry().get(SEPT_B2).clone();
        System.out.println("DEBUG");
    }
}
