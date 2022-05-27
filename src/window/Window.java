package window;


import static java.lang.System.out;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
enum ComponentPositions
{
    LEFT,
    MIDDLE,
    RIGHT,
    TOP,
    BOTTOM,
}


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


    public void bootscreen()
    {
        out.println("\n\n\n\n\n\n");
        out.println("\t\t\t\t\t\t _____     _                          _              _            ");
        out.println("\t\t\t\t\t\t(  _  )   ( )          _       _     ( )_           ( )_ _        ");
        out.println("\t\t\t\t\t\t| (_) |  _| | ___ ___ (_) ___ (_) ___|  _)_ __   _ _|  _)_)  __   ");
        out.println("\t\t\t\t\t\t(  _  )/ _  |  _   _    |  _    |  __) | (  __)/ _  ) | | |/ __   ");
        out.println("\t\t\t\t\t\t| | | | (_| | ( ) ( ) | | ( ) | |__    |_| |  ( (_| | |_| |  ___/ ");
        out.println("\t\t\t\t\t\t(_) (_) __ _)_) (_) (_)_)_) (_)_)____/ __)_)    __ _) __)_)  ___) ");  
        out.println("\n\n\n");
        out.println("\t\t\t\t\t\tCopyright: Niko van Ommen - 1030808 - 2022");
        out.println("\n\n\n");
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
