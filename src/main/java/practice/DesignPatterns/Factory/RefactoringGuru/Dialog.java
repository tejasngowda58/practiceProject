package practice.DesignPatterns.Factory.RefactoringGuru;

public abstract class Dialog {
    int dimension;

    public int getDimension(){
        return dimension;
    }
    public abstract Button createButton();

}
