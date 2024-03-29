package main;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
public class Colors 
{
    ///
    /// Standard available colors
    ///
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_WHITE = "\u001B[37m"; 
    
    
    ///
    /// Standard available frases
    ///
    public static final String PRINT_INFO = "[" + TEXT_BLUE + "info" + TEXT_RESET + "]\t\t";
    public static final String PRINT_ERROR = "[" + TEXT_RED + "error" + TEXT_RESET + "]\t\t";
    public static final String PRINT_WARNING = "[" + TEXT_YELLOW + "warning" + TEXT_RESET + "]\t";
    public static final String PRINT_SUCCESS = "[" + TEXT_GREEN + "success" + TEXT_RESET + "]\t";


    ///
    /// Functions to print colors in text
    ///
    public static String printCharsInColor(String phrase, String color)
    {
        switch (color.toLowerCase())
        {
            case "red":
                return TEXT_RED + phrase + TEXT_RESET;
            case "black":
                return TEXT_RED + phrase + TEXT_RESET;
            case "green":
                return TEXT_RED + phrase + TEXT_RESET;
            case "blue":
                return TEXT_RED + phrase + TEXT_RESET;
            case "purple":
                return TEXT_RED + phrase + TEXT_RESET;
            case "cyan":
                return TEXT_RED + phrase + TEXT_RESET;
            case "yellow":
                return TEXT_RED + phrase + TEXT_RESET;
            case "white":
                return TEXT_RED + phrase + TEXT_RESET;
            default:
                return TEXT_RESET + phrase; 
        }
    }
}
