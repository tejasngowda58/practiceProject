package practice.DesignPatterns.Factory.RefactoringGuru;

public class iOSDialog extends Dialog{
    @Override
    public Button createButton() {
        return new iOSButton();
    }
}
