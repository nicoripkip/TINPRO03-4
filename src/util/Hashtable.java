package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import util.KeyPair;


/**
 * @author Nico van Ommen | 1030808
 * @since 02/07/2023
 */
public class Hashtable<T, U>
{
    private static final int    MAX_TABLE_SIZE  = 300;


    private ArrayList<KeyPair<T, U>> _data;


    /**
     * Constructor
     * 
     */
    public Hashtable()
    {
        this.setValues(new ArrayList<KeyPair<T, U>>(Collections.nCopies(MAX_TABLE_SIZE, null)));
    }


    /**
     * Function to convert generic value to a long value
     * 
     * @param <V>
     * @param key
     * @return
     */
    private <V> int convertToNumber(V key)
    {
        String k = key.toString();
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(regex);

        if (matcher.matches()) {
            return Integer.parseInt(k);
        } else {
            int v = 0;

            for (int i = 0; i < k.length(); i++) {
                v += (int)k.charAt(i);
            }

            return v;
        }
    }


    /**
     * Function to hash a key by the mulitplication method
     * 
     * @param key
     * @return
     */
    private int hash(T key)
    {
        int k = convertToNumber(key);
        return (int)Math.floor(((MAX_TABLE_SIZE/2) * k * Math.E*0.25) % MAX_TABLE_SIZE);
    }


    /**
     * Method to check if a given key exists in the hash table
     * 
     * @param key
     * @return
     */
    public boolean containsKey(T key)
    {
        int k = hash(key);

        // System.out.println("Key: " + k);

        if (this.getValues().get(k) != null && this.getValues().get(k).getKey().equals(key)) {
            return true;
        }

        return false;
    }


    /**
     * Method to get a value by a given key in the hash table
     * 
     * @param key
     * @return
     */
    public U get(T key)
    {
        if (key.toString().length() <= 0) {
            return null;
        }

        int index = hash(key);

        System.out.println("Key: " + index);

        return this.getValues().get(index).getValue();
    }


    /**
     * Function to insert new values in the hashtable
     * 
     * @param key
     * @param value
     */
    public void insert(T key, U value)
    {
        if (key.toString().length() <= 0) {
            return;
        }

        int index = hash(key);

        if (this.getValues().get(index) == null) {
            KeyPair<T, U> kp = new KeyPair<T, U>();

            kp.setKey(key);
            kp.setValue(value);

            this.getValues().add(index, kp);
        } else {
            return;
        }
    }


    /**
     * Method to delete an entry from the hash table
     * 
     */
    public void delete()
    {

    }


    /**
     * Method to set the arraylist in the hash table
     * 
     * @param values
     */
    public void setValues(ArrayList<KeyPair<T, U>> values)
    {
        this._data = values;
    }


    /**
     * 
     * 
     * @return
     */
    public ArrayList<KeyPair<T, U>> getValues()
    {
        return this._data;
    }


    public int size()
    {
        return 0;
    }
}
