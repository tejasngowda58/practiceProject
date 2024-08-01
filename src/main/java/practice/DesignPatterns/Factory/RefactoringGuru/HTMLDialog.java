package practice.DesignPatterns.Factory.RefactoringGuru;

public class HTMLDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
