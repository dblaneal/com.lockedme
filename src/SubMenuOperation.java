import java.io.File;
import java.util.Scanner;

import static java.lang.System.exit;

public class SubMenuOperation {
    FileHandler fh;
    public SubMenuOperation(FileHandler fh){
        this.fh = fh;
    }

    // Method for displaying submenu screen and operate as per user input.
    public void runSubMenu(){
        Scanner sc = new Scanner(System.in);
        int option = 1;
        int totalMenu = MenuHandler.subMenuOptions.length;

        while (option != 4){
            MenuHandler.printSubMenu();

            try {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("\n#Add file operation");
                        fh.addFile();
                        HelperMethod.waitForEnterKey();
                        break;
                    case 2:
                        System.out.println("\n#Delete file operation");
                        fh.deleteFile();
                        HelperMethod.waitForEnterKey();
                        break;
                    case 3:
                        System.out.println("\n#Search file operation");
                        fh.searchFile();
                        HelperMethod.waitForEnterKey();
                        break;
                    case 4:
                        System.out.println("Return to Main menu");
                        break;
                    default:
                        System.out.println(MenuHandler.errorMsg(totalMenu));
                        sc.next();
                }

            }catch (Exception ex){
                System.out.println(MenuHandler.errorMsg(totalMenu));
                sc.next();
            }
        }
    }
}
