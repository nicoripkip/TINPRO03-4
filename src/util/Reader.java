package util;


import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;


/**
 * @author Nico van Ommen | 1030808
 * @since 05/08/2023
 */
public class Reader 
{
    /**
     * Method to read from file by a given path
     * 
     * @param path
     * @return
     * @throws IOException
     */
    private static BufferedReader readFile(String path) throws IOException
    {
        return Files.newBufferedReader(Paths.get(URI.create(path)), StandardCharsets.UTF_8);
    }


    /**
     * Method to trim the stringbuilder object from all whitespaces
     * 
     * @param sb
     * @return
     */
    private static StringBuilder removeBlankSpace(StringBuilder sb) 
    {
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


    /**
     * Method to convert the data from the buffer into a string object
     * 
     * @param path
     * @return
     * @throws IOException
     */
    public static String getDataFromFile(String path) throws IOException
    {
        BufferedReader reader = readFile(path);      
        StringBuilder resultString = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null) {
            resultString.append(line);
        }

        // removeBlankSpace(resultString);

        return resultString.toString();
    }
}
