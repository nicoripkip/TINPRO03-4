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
     */
    public Window()
    {
        // TODO: not implemented
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
        out.println("\t\t\t\t\t\tCopyright: Niko van Ommen - 1030808 - 2023");
        out.println("\n\n\n");
    }
}
