package window;


import java.awt.*;

import javax.swing.JFrame;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
public class Window
{
    private int _width;
    private int _height;
    private String _windowText;


    /**
     * Constructor
     * 
     * @param width
     * @param height
     * @param windowText
     */
    public Window(int width, int height, String windowText)
    {
        this.setWindowWidth(width);
        this.setWindowHeight(height);
        this.setWindowText(windowText);
    }


    /**
     * Methode voor het bouwen van het scherm
     */
    public void initialize()
    {
        JFrame frame = new JFrame(this.getWindowText());

        frame.setSize(this.getWindowWidth(), this.getWindowHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    /**
     * Methode voor het zetten van de window breedte
     * 
     * @param width
     */
    public void setWindowWidth(int width)
    {
        this._width = width;
    }


    /**
     * Methode voor het ophalen van de window breedte
     * 
     * @return int
     */
    public int getWindowWidth()
    {
        return this._width;
    }


    /**
     * Methode voor het instellen van de window hoogte
     * 
     * @param height
     */
    public void setWindowHeight(int height)
    {
        this._height = height;
    }


    /**
     * Methode voor het ophalen van de window hoogte
     * 
     * @return int
     */
    public int getWindowHeight()
    {
        return this._height;
    }


    /**
     * Methode voor het zetten van de windowtext
     * 
     * @param text
     */
    public void setWindowText(String text)
    {
        this._windowText = text;
    }


    /**
     * Methode voor het ophalen van de window text
     * 
     * @return String
     */
    public String getWindowText()
    {
        return this._windowText;
    }
}
