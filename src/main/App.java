package main;


import window.Window;
import static java.lang.System.out;

import netscape.javascript.JSObject;
import util.Reader;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
public class App
{
    private static final String BASE_STRING = "file:///C:/Users/Nicki/Documents/Projecten/Java/TINPRO03-4/";

    /**
     * Methode voor het starten van het programma
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception 
    {
        Window window = new Window();
        window.bootscreen();

        String data = Reader.getDataFromFile(BASE_STRING + "studentData.json");

        HTTP    

        System.out.println(Colors.PRINT_INFO + data);
    }
}