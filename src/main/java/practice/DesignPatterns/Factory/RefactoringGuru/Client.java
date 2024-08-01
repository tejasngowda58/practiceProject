package practice.DesignPatterns.Factory.RefactoringGuru;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) {
        try {
            createDialog("web");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public static void createDialog(String systemConfig) throws FileNotFoundException {
        Dialog dialog;

        switch (systemConfig) {
            case "windows":
                dialog = new WindowsDialog();
                break;
            case "iOS":
                dialog = new iOSDialog();
                break;
            case "web":
                dialog = new HTMLDialog();
                break;
            default:
                throw new FileNotFoundException();
        }

        System.out.println(dialog.getDimension());
        Button button = dialog.createButton();
        button.onClick();
        button.render();
    }
}
