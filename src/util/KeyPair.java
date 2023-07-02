package util;


/**
 * @author Nico van Ommen | 1030808
 * @since 02/07/2023
 */
public class KeyPair<T, V>
{
    private T _key;
    private V _value;


    public void setKey(T key)
    {
        this._key = key;
    }


    public void setValue(V value)
    {
        this._value = value;
    }


    public T getKey()
    {
        return this._key;
    }


    public V getValue()
    {
        return this._value;
    }
}
