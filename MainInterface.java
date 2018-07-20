import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * Create a class for Conference Information System.
 * 
 * @author Jyh-woei Yang 
 * @version 20/07/2018
 */
public class MainInterface
{
    // instance variables - replace the example below with your own
    private Driver driver;

    /**
     * Default Constructor for objects of class User System
     */
    public MainInterface()
    {
        // initialise instance variables
        driver = new Driver();
    }   

    /**
     * A method to display Menu
     * 
     * @param
     * @return 
     */

    private void displayMenu()
    {
        //interface
        System.out.println("");
        System.out.println("=====================");
        System.out.println("(1) Search User");
        System.out.println("(2) Add User");
        System.out.println("(3) Delete User");
        System.out.println("(4) Edit User (Password and UserType)");
        System.out.println("(5) Exit System");
        System.out.print("Choose an option :");
    }

    /**
     * A method to read from file
     * 
     * @param  
     * @return
     * @throws FileNotFoundException if file is not found
     * @throws IOException while exception during I/O actions
     */
    private void readFile()
    {
        String filename = ("myDictionary.txt");
        String staff;
        Dictionary loadFromFile;
        // try catch to handle FileNotFoundException and IOException
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            int linecount = 0;
            while (parser.hasNextLine())
            {
                loadFromFile = new Dictionary(); 
                staff = parser.nextLine();
                String[] attribute = staff.split(",");

                for (int i = 0 ; i < attribute.length ; i++)
                {
                   System.out.println (attribute[i]);

                }

                System.out.println ("User"+ linecount);
                //loadFromFile.setUsername(attribute[0]);
                //loadFromFile.setPassword(attribute[1]);
                //loadFromFile.setUsertype(attribute[2]);
                
                //add user to the list
                Dictionary newDictionary = new Dictionary();                               

                //loadFromFile.displayUserRecord();
                //newUserList.addUser(loadFromFile);
                linecount++;
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
    /**
     * A method to start operating the system
     * 
     * @param
     * @return 
     */
    public void start()
    {
        //Scanner
        Scanner input = new Scanner(System.in);
        Boolean isOperating = true;

        //read from file
        readFile();

        while (isOperating)
        {                        
            //display menu 
            displayMenu();

            //insert case
            String iobuffer = input.nextLine(); 
            System.out.println("");
            String option = iobuffer;

                    switch (option.charAt(0))
                    {
                        case '1':
                        //search User from the list by username
                        System.out.println("(1)");
                        break;
                        case '2':
                        //add User to the list
                        System.out.println("(2)");
                        break;
                        case '3':
                        //delete User from the list
                        System.out.println("(3)");
                        break;
                        case '4':
                        //Edit User from the list (Password and Usertype) (HD)
                        System.out.println("(4)");
                        break;
                        case '5':
                        //Exit system, and reset variables
                        System.out.println("Exit System");
                        isOperating = false;
                        break;
                    }
                }

                if (!isOperating)
                {
                    System.out.println("");
                    System.out.println("Thank you for using User Database System, Goodbye!");
                }
    }

    /**
     * Method to convert from String to Integer
     * 
     * @param a String of input
     * @return the Integer of out
     * @throws NumberFormatException if input is a non-number format
     */
    private int convertStringtoInt(String input) //method to convert String to Integer
    {
        //intialised variables
        String S = input;
        int i = 0;
        //try catch to handle NumberFormatException
        try
        {
            // the String to int conversion happens here
            i = Integer.parseInt(input.trim());

            // print out the value after the conversion
            //System.out.println("int i = " + i);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage() + ", please input an integer!");
        }
        return i;
    }
    

}