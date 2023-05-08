package person;


import java.time.LocalDate;


/**
 * @author Nico van Ommen
 * @since 05/10/2022
 */
public class Student extends BasePerson 
{
    private long _studentNumber;


    /**
     * Constructor
     * 
     * @param firstname
     * @param lastname
     * @param dateOfBirth
     */
    public Student(String firstname, String lastname, LocalDate dateOfBirth, Gender gender, long number)
    {
        super(firstname, lastname, dateOfBirth, gender);

        this.setStudentNumber(number);
    }


    /**
     * Methode voor het zetten van het studentnummer 
     * 
     * @param number
     */
    public void setStudentNumber(long number)
    {
        this._studentNumber = number;
    }


    /**
     * Methode voor het ophalen van de student nummer
     * 
     * @return
     */
    public long getStudentNumber()
    {
        return this._studentNumber;
    }
}
