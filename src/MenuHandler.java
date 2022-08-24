import static java.lang.System.exit;

public class MenuHandler {

    static String[] mainMenuOptions= {
            "\n1 - List files",
            "2 - Sub Option",
            "3 - Exit"
    };

    static String[] subMenuOptions = {
           "\n1 - Add file",
            "2 - Delete file",
            "3 - Search file",
            "4 - Main Menu"
    };

    public static void printMainMenu(){
        HelperMethod.clearConsole();
        for (String menu: mainMenuOptions){
            System.out.println(menu);
        }
        System.out.print("Choose your option: ");
    }

    public static void printSubMenu(){
        HelperMethod.clearConsole();
        for (String menu: subMenuOptions){
            System.out.println(menu);
        }
        System.out.print("Choose your option: ");
    }

    public static String errorMsg(int totalMenu){
        return "Please enter number between 1 to " + String.valueOf(totalMenu);
    }

    public static void exitProgram() throws InterruptedException {
        HelperMethod.clearConsole();
        System.out.println("\nThank you for using 'Lockedme.com'");
        Thread.sleep(3000); // wait for 3 seconds
        HelperMethod.clearConsole();
        exit(0);
    }
}
