package window;


import java.awt.GridLayout;
import java.awt.Color;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
    private JFrame _frame;
    private JPanel _header;
    private JPanel _panel;


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

        this._frame = new JFrame(this.getWindowText());
        this._header = new JPanel();
        this._panel = new JPanel();
    }


    /**
     * Methode voor het bouwen van het scherm
     */
    public void initialize()
    {
        // Initialiseer de raam functies
        this.getWindowFrame().setSize(this.getWindowWidth(), this.getWindowHeight());
        this.getWindowFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getWindowFrame().setVisible(true);
        this.getWindowFrame().setResizable(false);
        this.getWindowFrame().setLocationRelativeTo(null);

        // Initialiseer de panel opties
        this.getWindowHeader().setSize(1340, 100);
        this.getWindowHeader().setLayout(new GridLayout(1, 1));
        this.getWindowHeader().setLocation(5, 0);
        this.getWindowHeader().setBorder(BorderFactory.createLineBorder(Color.black));

        // Voeg onderdelen toe aan de panel
        this.getWindowHeader().add(this.CustomJLabelComponent("Administratiesysteem", ComponentPositions.MIDDLE, 100));

        // Voeg onderdelen toe aan het frame
        this.getWindowFrame().add(this.getWindowHeader());
    }


    /**
     * Methode voor het toevoegen van een custom jpanel object
     * 
     * @param text
     * @param position
     * @param size
     * @return JLabel
     */
    private JLabel CustomJLabelComponent(String text, ComponentPositions position, int size)
    {
        JLabel label = new JLabel();

        label.setText(text);
        label.setSize(new Dimension(1340, 50));
        
        switch (position)
        {
            case LEFT:
                label.setHorizontalAlignment(JLabel.LEFT);
            break;
            case MIDDLE:
                label.setHorizontalAlignment(JLabel.CENTER);
            break;
            case RIGHT:
                label.setHorizontalAlignment(JLabel.RIGHT);
            break;
        }

        return label;
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


    /**
     * Methode voor het ophalen van de window frame
     * 
     * @return JFrame
     */
    private JFrame getWindowFrame()
    {
        return this._frame;
    }

    /**
     * Methode voor het ophalen van de window panel
     * 
     * @return JPanel
     */
    private JPanel getWindowHeader()
    {
        return this._header;
    }


    /**
     * Methode voor het ophalen van de window panel
     * 
     * @return JPanel
     */
    private JPanel getWindowPanel()
    {
        return this._panel;
    }
}
