package window;


import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import administration.Administration;
import person.Student;
import util.KeyPair;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
public class Window
{
    static int _paginationValue;
    Administration _administration = new Administration();


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


    public void pagination(String result)
    {
        switch (result)
        {
            case "A":
                if (_paginationValue == 0) {
                    subjectmenu();
                } else if (_paginationValue == 1) {
                    courses();
                } else if (_paginationValue == 2) {
                    menu();
                } 
                break;
            case "B":
                if (_paginationValue == 0) {
                    studentmenu();
                } else if (_paginationValue == 1) {
                if (_paginationValue == 0) {
                    break;
                } else if (_paginationValue == 1) {

                }
                }
                break;
            case "C":

                break;
            case "D":

                break;
            case "E":

                break;
            case "F":

                break;
            case "G":

                break;
            case "H":

                break;
            case "I":
                if (_paginationValue == 1) {
                    menu();
                } 
                break;
            case "Q":
                if (_paginationValue == 3) {
                    menu();
                }
                break;
            default:
                menu();
                break;
        }
    }


    private void menu()
    {
        _paginationValue = 0;

        System.out.println("\t\t");
        System.out.println("\t\t---- Hoofd menu ----");
        System.out.println("\t\t");
        System.out.println("A) Algemene zaken");
        System.out.println("B) Studentenzaken");
        System.out.println("c) Afsluiten");

        System.out.print("Toets uw character: ");
        Scanner scanner = new Scanner(System.in);

        String r = scanner.nextLine();

        pagination(r);
    }


    private void studentmenu()
    {
        _paginationValue = 1;
        System.out.println("\t\t");
        System.out.println("\t\t---- Studentenzaken ----");
        System.out.println("\t\t");
        System.out.println("A) Studenten per klas");
        System.out.println("B) Studenten per vak");
        System.out.println("C) Student openstaande vakken");
        System.out.println("D) Student afgeronde vakken");
        System.out.println("E) Gemiddelde cijfer student");
        System.out.println("F) Gewogen gemiddelde student");
        System.out.println("G) Percentage studenten vak gehaald");
        System.out.println("H) Student progressie"); 
        System.out.println("I) Terug");

        System.out.print("Toets uw character: ");
        Scanner scanner = new Scanner(System.in);

        String r = scanner.nextLine();
        pagination(r);

    }


    private void subjectmenu()
    {
        _paginationValue = 2;
        System.out.println("\t\t");
        System.out.println("\t\t---- Algemene zaken ----");
        System.out.println("\t\t");
        System.out.println("A) Terug");

        System.out.print("Toets uw character: ");
        Scanner scanner = new Scanner(System.in);

        String r = scanner.nextLine();
        pagination(r);
    }


    private void courses()
    {
        _paginationValue = 3;
        System.out.println("\t\t");
        System.out.println("\t\t---- Studenten in een klas ----");
        System.out.println("\t\t");

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer de opleiding in: ");
        String c = scanner.nextLine();

        System.out.print("Voer de klas in: ");
        scanner = new Scanner(System.in);
        String g = scanner.nextLine();

        this._administration.printStudentsByGroup(c, g);

        System.out.println("Q) Terug");

        scanner = new Scanner(System.in);
        System.out.print("Toets uw character: ");
        String r = scanner.nextLine();
        pagination(r);
    }


    private void groups()
    {
        _paginationValue = 4;
        System.out.println("\t\t");
        System.out.println("\t\t---- Klasen ----");
        System.out.println("\t\t");

        for (KeyPair<String, List<Student>> l : Administration.ListOfStudents.getValues()) {
            if (l != null) {
                for (int i = 0; i < l.getValue().size(); i++) {
                    l.getValue().get(i).getGroup();
                }
            }
        }
    }
}
