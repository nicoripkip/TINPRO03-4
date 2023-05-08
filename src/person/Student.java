package person;


import java.time.LocalDate;
import subject.CourseSubject;


/**
 * @author Nico van Ommen
 * @since 05/10/2022
 */
public class Student extends BasePerson 
{
    private long _studentNumber;
    private String _course;
    private int _currentYear;
    private CourseSubject[] _totalSubjects;
    private CourseSubject[] _openSubjects;


    /**
     * Constructor
     * 
     * @param firstname
     * @param lastname
     * @param dateOfBirth
     */
    public Student(String firstname, String lastname, LocalDate dateOfBirth, long number, String course, int year)
    {
        super(firstname, lastname, dateOfBirth);

        this.setStudentNumber(number);

        this.setCourse(course);
        this.setCurrentYear(year);

        this.setTotalSubjects(new CourseSubject[10]);
        this.setOpenSubjects(new CourseSubject[10]);
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
     * Methode voor het zetten van de Studie
     * 
     * @param course
     */
    public void setCourse(String course)
    {
        this._course = course;
    }


    /**
     * Methode voor het zetten van het jaar
     * 
     * @param year
     */
    public void setCurrentYear(int year)
    {
        this._currentYear = year;
    }


    /**
     * Methode voor het zetten van de totaal aantal vakken
     * 
     * @param total
     */
    public void setTotalSubjects(CourseSubject[] total)
    {
        this._totalSubjects = total;
    }


    /**
     * Methode voor het zetten van de openstaande vakken
     * 
     * @param open
     */
    public void setOpenSubjects(CourseSubject[] open)
    {
        this._openSubjects = open;
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


    /**
     * Methode voor het ophalen van de Studie
     * 
     * @param course
     */
    public String getCourse()
    {
        return this._course;
    }


    /**
     * Methode voor het ophalen van het jaar
     * 
     * @param year
     */
    public int getCurrentYear()
    {
        return this._currentYear;
    }


    /**
     * Methode voor het ophalen van de totaal aantal vakken
     * 
     * @param total
     */
    public CourseSubject[] getTotalSubjects()
    {
        return this._totalSubjects;
    }


    /**
     * Methode voor het ophalen van de openstaande vakken
     * 
     * @param open
     */
    public CourseSubject[] setOpenSubjects()
    {
        return this._openSubjects;
    } 
}
