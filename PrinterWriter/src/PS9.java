
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class PS9 {

    /**
     * Pre/Postcondition: takes the file name and input created by user and
     * makes a file.
     */
    public static void writeFile(String fileName, String file) {
        String toDoList = file;
        // declare PrintWriter before initializing, so it can be use
        // outside the try block.
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.out.print("Couldn't open file: " + e.getMessage());
            System.exit(0);
        }

        outputStream.println(toDoList.substring(1, toDoList.length() - 6)); //This makes it so the word "DONE" and the space at the start is not included. 
        outputStream.close(); // If I forget this, the file may not write.	
        System.out.println("\nFinished writing to file.\n");
    }

    /**
     * Pre/Postcondition: reads the file aswell as adds numbers to each line and
     * a title.
     */
    public static void readFile(String fileName) {
        System.out.println("Now reading file...\n");
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.print("Couldn't open file: " + e.getMessage());
            System.exit(0);
        }
        int i = 0;
        String[] inputs = new String[0];
        System.out.print("My To-dos:\n");
        while (inputStream.hasNextLine()) {
            i++;// makes it so a number can be added to each line.
            String line = inputStream.nextLine();
            inputs = line.split(", ");
            for (String toPrint : inputs) {
                System.out.print(i + ". " + toPrint);
            }
            System.out.println();
        }
        inputStream.close();
    }

    /**
     * Precondition: Ask for file name and input to be written to a file.
     * Postcondition: Executes the methods to write and read the file
     * afterf=wards.
     */
    public static void main(String[] args) {
        String fileName;
        String file = "";
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the name of the file to be created: ");

        fileName = keyboard.next();

        System.out.print("\nWrite a  to-dos list which contains items to be completed(type DONE once finished.)\n");

        while ((file.indexOf("DONE") + 5) != file.length())//checks to see if the index of DONE plus 5 == the length of file.
        {
            file += keyboard.nextLine() + "\n";
        }
        keyboard.close();
        writeFile(fileName, file);// calls the methods to finish up the work. 
        readFile(fileName);
    }
}
