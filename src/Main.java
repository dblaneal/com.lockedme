import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        HelperMethod.lunchApp();
        runProgramme();
    }

    public static void runProgramme(){
        Scanner sc = new Scanner(System.in);
        int option = 1;
        int totalMenu = MenuHandler.mainMenuOptions.length;

        FileHandler fh = new FileHandler();

        while (option != 3){
            MenuHandler.printMainMenu();
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        fh.listFiles();
                        break;
                    case 2:
                        new SubMenuOperation(fh).runSubMenu();
                        break;
                    case 3:
                       MenuHandler.exitProgram();
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