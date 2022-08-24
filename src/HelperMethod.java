import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class HelperMethod {

    private static final String[] supportedFileExtension = {"doc", "docx","pdf","xls","ppt","txt"};
    // Helper method to clear console as according to OS.
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }

    // Wait until Enter key is pressed
    public static void waitForEnterKey(){

        System.out.println("\n#Press enter to continue....");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    // Get Extension from fileName
    public static String getFileExtension(String fileName){
        String extension = "";
        int index = fileName.lastIndexOf(".");
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }
        return extension;
    }

    // Check whether user provide file extension is valid or not.
    public static boolean isValidFileExtension(String ext){
        return Arrays.stream(supportedFileExtension).anyMatch(ext:: equals);
    }

    public static String supportedExtensions(){
        String extInfo="";
        for(String ext: supportedFileExtension){
            extInfo += ext + ", ";
        }
        return extInfo;
    }

    public static String logo(){
        return "\n" +
                "██╗      ██████╗  ██████╗██╗  ██╗███████╗██████╗ ███╗   ███╗███████╗    ██████╗ ██████╗ ███╗   ███╗\n" +
                "██║     ██╔═══██╗██╔════╝██║ ██╔╝██╔════╝██╔══██╗████╗ ████║██╔════╝   ██╔════╝██╔═══██╗████╗ ████║\n" +
                "██║     ██║   ██║██║     █████╔╝ █████╗  ██║  ██║██╔████╔██║█████╗     ██║     ██║   ██║██╔████╔██║\n" +
                "██║     ██║   ██║██║     ██╔═██╗ ██╔══╝  ██║  ██║██║╚██╔╝██║██╔══╝     ██║     ██║   ██║██║╚██╔╝██║\n" +
                "███████╗╚██████╔╝╚██████╗██║  ██╗███████╗██████╔╝██║ ╚═╝ ██║███████╗██╗╚██████╗╚██████╔╝██║ ╚═╝ ██║\n" +
                "╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝╚══════╝╚═════╝ ╚═╝     ╚═╝╚══════╝╚═╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝\n" +
                "                                                                                                   \n";
    }

    public static void lunchApp(){
        HelperMethod.clearConsole();
        System.out.println(logo());
        System.out.println("\nDeveloper: Anil Dhaubhadel");
        System.out.println("\n\n");

        waitForEnterKey();
        clearConsole();
    }

}
