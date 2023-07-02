package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * @author Nico van Ommen | 1030808
 * @since 02/07/2023
 */
public class Hashmap<T, U>
{
    private static final double GOLDEN_RATIO    = 0.61803398;
    private static final int    MAX_TABLE_SIZE  = 300;


    private ArrayList<T> keys;
    private LinkedList<U> data;


    /**
     * Function to convert generic value to a long value
     * 
     * @param <V>
     * @param key
     * @return
     */
    private <V> long convertToNumber(V key)
    {
        String k = key.toString();
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(regex);

        if (matcher.matches()) {
            return Long.parseLong(k);
        } else {
            return k.length();
        }
    }


    /**
     * Function to hash a key by the mulitplication method
     * 
     * @param key
     * @return
     */
    private long hash(T key)
    {
        long k = convertToNumber(key);
        return (MAX_TABLE_SIZE * k * 1) % MAX_TABLE_SIZE;
    }


    public U get(T key)
    {
        return null;
    }


    public void insert(U value)
    {

    }


    public void delete()
    {

    }


    public ArrayList<T> getKeys()
    {
        return this.keys;
    }


    public LinkedList<U> getValues()
    {
        return this.data;
    }
}
