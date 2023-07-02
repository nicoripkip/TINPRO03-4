package person;


import java.time.LocalDate;


/**
 * @author Nico van Ommen
 * @since  05/10/2022
 */
abstract class BasePerson
{
    private String _name;
    private LocalDate _dateOfBirth;


    /**
     * Constructor
     * 
     * @param firstname
     * @param lastname
     * @param dateOfBirth
     */
    public BasePerson(String firstname, LocalDate dateOfBirth)
    {
        this.setName(firstname);
        this.setDateOfBirth(dateOfBirth);
    }


    /**
     * Methode voor het zetten van de voornaam
     * 
     * @param firstname
     */
    public void setName(String name)
    {
        this._name = name;
    }


    /**
     * Methode voor het ophalen van de voornaam
     * 
     * @return String
     */
    public String getName()
    {
        return this._name;
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
}