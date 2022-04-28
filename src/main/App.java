package main;


import window.Window;
import static java.lang.System.out;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
public class App
{
    /**
     * Methode voor het starten van het programma
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception 
    {
        Window window = new Window(1366, 768, "Administratie systeem");

        window.initialize();
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tJava window opgestart!");
    }
}