package main;


import window.Window;
import static java.lang.System.out;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;


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

        String data = getDataFromFile();

        System.out.println(Colors.PRINT_INFO + data);
    }


    private static BufferedReader readFile(String path) throws IOException
    {
        return Files.newBufferedReader(Paths.get(URI.create(path)), StandardCharsets.UTF_8);
    }


    private static StringBuilder removeBlankSpace(StringBuilder sb) {
        int currentEnd = -1;
        for(int i = sb.length() - 1; i >= 0; i--) {
            if (Character.isWhitespace(sb.charAt(i))) {
                if (currentEnd == -1) {
                    currentEnd = i + 1;
                }
            } else {
                // Moved from whitespace to non-whitespace
                if (currentEnd != -1) {
                    sb.delete(i + 1, currentEnd);
                    currentEnd = -1;
                }
            }
        }
        // All leading whitespace
        if (currentEnd != -1) {
            sb.delete(0, currentEnd);
        }
        return sb;
    }


    private static String getDataFromFile() throws IOException
    {
        BufferedReader reader = readFile(BASE_STRING + "studentData.json");      
        StringBuilder resultString = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null) {
            resultString.append(line);
        }

        removeBlankSpace(resultString);

        return resultString.toString();
    }
}