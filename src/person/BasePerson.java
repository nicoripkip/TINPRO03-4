package person;


import java.time.LocalDate;


/**
 * @author Nico van Ommen
 * @since  05/10/2022
 */
abstract class BasePerson
{
    private String _firstname;
    private String _lastname;
    private LocalDate _dateOfBirth;
    private Gender _gender;


    /**
     * Constructor
     * 
     * @param firstname
     * @param lastname
     * @param dateOfBirth
     */
    public BasePerson(String firstname, String lastname, LocalDate dateOfBirth, Gender gender)
    {
        this.setFirstName(firstname);
        this.setLastName(lastname);
        this.setDateOfBirth(dateOfBirth);
        this.setGender(gender);
    }


    /**
     * Methode voor het zetten van de voornaam
     * 
     * @param firstname
     */
    public void setFirstName(String firstname)
    {
        this._firstname = firstname;
    }


    /**
     * Methode voor het ophalen van de voornaam
     * 
     * @return String
     */
    public String getFirstName()
    {
        return this._firstname;
    }


    /**
     * Methode voor het zetten van de achternaam
     * 
     * @param lastname
     */
    public void setLastName(String lastname)
    {
        this._lastname = lastname;
    }


    /**
     * Methode voor het ophalen van de achternaam
     * 
     * @return
     */
    public String getLastName()
    {
        return this._lastname;
    }


    /**
     * Methode voor het zetten van de geboortedatum
     * 
     * @param date
     */
    public void setDateOfBirth(LocalDate date)
    {
        this._dateOfBirth = date;
    }


    /**
     * Methode voor het ophalen van de geboortedatum
     * 
     * @return
     */
    public LocalDate getDateOfBirth()
    {
        return this._dateOfBirth;
    }


    /**
     * Methode voor het ophalen van de leeftijd
     * 
     * @return
     */
    public int getAge()
    {
        return LocalDate.now().getYear() - this._dateOfBirth.getYear();
    }


    /**
     * Methode voor het zetten van de gender
     * 
     * @param gender
     */
    public void setGender(Gender gender)
    {
        this._gender = gender;
    }


    /**
     * Methode voor het ophalen van het gender
     * 
     * @return
     */
    public Gender getGender()
    {
        return this._gender;
    }
}