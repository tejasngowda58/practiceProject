package practice.DesignPatterns.Factory.RefactoringGuru;

public class HTMLButton implements Button{
    @Override
    public void onClick() {
        System.out.println("On click from HTML button");
    }

    @Override
    public void render() {
        System.out.println("Rendering from HTML buuton");
    }
}
