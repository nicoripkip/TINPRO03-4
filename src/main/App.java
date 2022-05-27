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
        Window window = new Window(800, 600, "Henk");
        window.bootscreen();
    }
}