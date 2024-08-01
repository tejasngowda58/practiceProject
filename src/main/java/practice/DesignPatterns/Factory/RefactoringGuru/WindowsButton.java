package practice.DesignPatterns.Factory.RefactoringGuru;

public class WindowsButton implements Button{
    @Override
    public void onClick() {
        System.out.println("On click from windows button");
    }

    @Override
    public void render() {
        System.out.println("Rendering from windows button");
    }
}
