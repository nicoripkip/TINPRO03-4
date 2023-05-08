package subject;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/28/2022
 */
public class CourseSubject
{
    private String   _courseCode;
    private int      _courseYear;
    private int      _totalEcs;
    private float    _grade;


    /**
     * Method to check if the subject is finished or not
     * 
     * @return boolean
     */
    public boolean subjectFinished()
    {
        if (this._grade > 5.5) {
            return true;
        }

        return false;
    }


    /**
     * Method to set the couse code
     * 
     * @param code
     */
    public void setCourseCode(String code)
    {
        this._courseCode = code;
    }


    /**
     * Method to set the course year
     * 
     * @param year
     */
    public void setCourseYear(int year)
    {
        this._courseYear = year;
    }


    /**
     * Method to set the total ecs
     * 
     * @param ecs
     */
    public void setECs(int ecs)
    {
        this._totalEcs = ecs;
    }


    /**
     * Method to set the grade of the course
     * 
     * @param grade
     */
    public void setGrade(float grade)
    {
        this._grade = grade;
    }


    /**
     * Method to get the course code
     * 
     * @return
     */
    public String getCourseCode()
    {
        return this._courseCode;
    }


    /**
     * Method to get
     * 
     * @return
     */
    public int getCourseYear()
    {
        return this._courseYear;
    }


    public int getECs()
    {
        return this._totalEcs;
    }


    public float getGrade()
    {
        return this._grade;
    }
}
