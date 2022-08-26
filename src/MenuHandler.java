import static java.lang.System.exit;

public class MenuHandler {
    // Main menu options
    static String[] mainMenuOptions= {
            "\n1 - List files",
            "2 - Sub Option",
            "3 - Exit"
    };
    // Sub menu options
    static String[] subMenuOptions = {
           "\n1 - Add file",
            "2 - Delete file",
            "3 - Search file",
            "4 - Main Menu"
    };

    // Prints the all main menu
    public static void printMainMenu(){
        HelperMethod.clearConsole();
        for (String menu: mainMenuOptions){
            System.out.println(menu);
        }
        System.out.print("Choose your option: ");
    }

    // Prints the sub menu option
    public static void printSubMenu(){
        HelperMethod.clearConsole();
        for (String menu: subMenuOptions){
            System.out.println(menu);
        }
        System.out.print("Choose your option: ");
    }

    // Prompts user to press the right option
    public static String errorMsg(int totalMenu){
        return "Please enter number between 1 to " + String.valueOf(totalMenu);
    }

    // Exit program printing 'Thank you...' msg
    public static void exitProgram() throws InterruptedException {
        HelperMethod.clearConsole();
        System.out.println("\nThank you for using 'Lockedme.com'");
        Thread.sleep(3000); // wait for 3 seconds
        HelperMethod.clearConsole();
        exit(0);
    }
}
