package practice.DesignPatterns.Factory.RefactoringGuru;

public class iOSButton implements Button{
    @Override
    public void onClick() {
        System.out.println("On click from iOS button");
    }

    @Override
    public void render() {
        System.out.println("Rendering from iOS button");
    }
}
