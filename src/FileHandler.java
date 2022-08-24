import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

    // List out all available files in default location with is desktop at the moment.
    public void listFiles(){
       try {
           File dir = new File(getDefaultFilePath());

           File[] files = dir.listFiles();
           Arrays.sort(files);
           if (files.length == 0) {
               System.out.println("The directory is empty");
           } else {
               System.out.println("\nAvailable Files and Directory:");
               System.out.println("-----------------------------------");

               for (File aFile : files) {
                   System.out.println(aFile.getName());
               }
               Scanner sc = new Scanner(System.in);
               System.out.println("-----------------------------------------------");
               System.out.println("Total files and directory found : "+ files.length);
               System.out.println("Location: "+ dir.getCanonicalPath());
               System.out.println("-----------------------------------------------");

               HelperMethod.waitForEnterKey();
           }
       }catch (Exception ex){
           System.out.println(ex);
       }

    }
    //Adding file in default location (Desktop)
    public void addFile(){
        System.out.print("#Enter file name to add: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        // just return if user provide empty file name.
        if (fileName.isEmpty()) {
            System.out.println("File name not provided!!");
            return;
        }

        String extension = HelperMethod.getFileExtension(fileName);

        // adding .txt as default file extension if user doesn't provide it.
        if(extension.isEmpty()) {
            extension = "txt";
            fileName += "."+extension;

        }
        // checking if it is valid extension - (this is the scenario when user provides file name with extension.)
        if (!HelperMethod.isValidFileExtension(extension)){
            System.out.println("OOPs.. The file extension is not supported!!");
            System.out.println("Currently Only " + HelperMethod.supportedExtensions() + " are supported!!");
            return;
        }

        boolean result;
        try{
            File file = new File(getDefaultFilePath() + fileName);
            result = file.createNewFile();
            if (result){
                System.out.println("\u2713 File successfully created " + file.getCanonicalPath());
            }
            else{
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        }catch (Exception ex) {
            System.out.print(ex);
        }
    }

    // Deleting files
    public void deleteFile(){
        System.out.print("Enter file name to delete: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        if (fileName.isEmpty()) {
            System.out.println("File name not provided!!");
            return;
        }
        try {
            File file = new File(getDefaultFilePath() + fileName);

            if(!file.exists()){
                System.out.println("File Not Found!!");
                return; // checking if file exists in default location.
            }

            String fCPath = file.getCanonicalPath();
            String fAPth = file.getAbsolutePath();

            if (compareString(fCPath, fAPth)){ // checking file name case-sensitivity
                    if (file.delete()) {
                        System.out.println("\u2713 File " + file.getName() + "  deleted successfully!!");
                    } else {
                        System.out.println("File deletion failed");
                    }
            }else {
                System.out.println("File Not Found!!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Search files
    public void searchFile(){
        System.out.print("Enter file name to search: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        if (fileName.isEmpty()) {
            System.out.println("File name not provided!!");
            return;
        }

        try {
            File directory = new File(getDefaultFilePath());

            if (directory.isDirectory() == true){

                MyFilenameFilter filter
                        = new MyFilenameFilter(fileName);

                String[] fileList = directory.list(filter);

                if (fileList == null) {
                    System.out.println("Empty directory or directory does not exists.");
                    return;
                }

                if (fileList.length == 0){
                    System.out.println("x File Not found at location: " +directory.getCanonicalPath());
                }
                else {
                    for (int i = 0; i < fileList.length; i++) {
                        System.out.println(fileList[i]);
                    }
                    System.out.println(fileList.length + " file(s) found!!");
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Get the default location as Desktop
    public String getDefaultFilePath(){
        String home = System.getProperty("user.home");
        return home + File.separator + "Desktop" + File.separator;
    }

    // Case-sensitive checking
    public boolean compareString(String str1, String str2){
        return str1.equals(str2);
    }

}

// MyFilenameFilter class implements FilenameFilter interface
class MyFilenameFilter implements FilenameFilter {

    String initials;

    // constructor to initialize object
    public MyFilenameFilter(String initials)
    {
        this.initials = initials;
    }

    // overriding the accept method of FilenameFilter
    // interface
    public boolean accept(File dir, String name)
    {
        return name.startsWith(initials);
    }
}