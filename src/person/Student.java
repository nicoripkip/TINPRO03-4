package person;


import java.time.LocalDate;
import java.util.List;

import subject.CourseSubject;


/**
 * @author Nico van Ommen
 * @since 05/10/2022
 */
public class Student extends BasePerson 
{
    private long _studentNumber;
    private String _course;
    private String _group;
    private String _currentYear;
    private List<CourseSubject> _totalSubjects;
    private List<CourseSubject> _openSubjects;


    /**
     * Constructor
     * 
     * @param firstname
     * @param lastname
     * @param dateOfBirth
     */
    public Student(String firstname, String group, LocalDate dateOfBirth, long number, String course, String year)
    {
        super(firstname, dateOfBirth);

        this.setStudentNumber(number);
        this.setGroup(group);
        this.setCourse(course);
        this.setCurrentYear(year);

        this.setTotalSubjects(null);
        this.setOpenSubjects(null);
    }


    public void Display()
    {
        System.out.println("Naam: " + this.getName());
        System.out.println("Klas: " + this.getGroup());
        System.out.println("Studie: " + this.getCourse());
        System.out.println("Studiejaar: " + this.getCurrentYear());
        System.out.println("Vakken:");
        for (int i = 0; i < this.getTotalSubjects().size(); i++) {
            System.out.println("\tNaam: " + this.getTotalSubjects().get(i).getCourseName());
            System.out.println("Cijfer: " + this.getTotalSubjects().get(i).getGrade());
        }
        System.out.println("Openstaande vakken:");
        for (int i = 0; i < this.getTotalSubjects().size(); i++) {
            if (!this.getTotalSubjects().get(i).subjectFinished()) {
                System.out.println("\tNaam: " + this.getTotalSubjects().get(i).getCourseName());
            }
        }
        System.out.println("\n");
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
    public void setCurrentYear(String year)
    {
        this._currentYear = year;
    }


    /**
     * Methode voor het zetten van de totaal aantal vakken
     * 
     * @param total
     */
    public void setTotalSubjects(List<CourseSubject> total)
    {
        this._totalSubjects = total;
    }


    /**
     * Methode voor het zetten van de klas
     * 
     * @param clazz
     */
    public void setGroup(String group)
    {
        this._group = group;
    }


    /**
     * Methode voor het zetten van de openstaande vakken
     * 
     * @param open
     */
    public void setOpenSubjects(List<CourseSubject> open)
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
    public String getCurrentYear()
    {
        return this._currentYear;
    }


    /**
     * Methode voor het ophalen van de totaal aantal vakken
     * 
     * @param total
     */
    public List<CourseSubject> getTotalSubjects()
    {
        return this._totalSubjects;
    }


    /**
     * Methode voor het ophalen van de openstaande vakken
     * 
     * @param open
     */
    public List<CourseSubject> setOpenSubjects()
    {
        return this._openSubjects;
    } 


    /**
     * Methode voor het ophalen van de klas
     * 
     * @param total
     */
    public String getGroup()
    {
        return this._group;
    }
}
