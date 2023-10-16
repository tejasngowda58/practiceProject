package practice.LLD;

public class PassByValue {
    public static void main(String[] args) {
        Foo f = new Foo("f");
        changeReference(f); // It won't change the reference!
        System.out.println(f.attribute);
        modifyReference(f); // It will modify the object that the reference variable "f" refers to!
    }

    public static void changeReference(Foo a) {
        Foo b = new Foo("b");
        a = b;

    }

    public static void modifyReference(Foo c) {
        c.setAttribute("c");
    }


}
class Foo{
    String attribute;
    void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    String getAttribute(){
        return this.attribute;
    }
    Foo(String attribute){
        this.attribute=attribute;
    }
}