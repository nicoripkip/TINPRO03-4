package main;


import window.Window;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import person.Student;
import subject.CourseSubject;
import util.KeyPair;
import util.Reader;
import org.json.*;
import administration.Administration;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
public class App
{
    private static final String BASE_STRING = System.getProperty("user.dir") + "/studentData.json";
    static boolean _stopProgram = false;
    static String page = "";


    /**
     * Methode voor het starten van het programma
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception 
    {
        System.out.println(BASE_STRING);

        Administration administration = new Administration();

        String data = Reader.getDataFromFile(BASE_STRING);
        JSONArray ja = new JSONArray(data);

        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);

            Student t = new Student(
                jo.getString("naam"), 
                jo.getString("klas"),
                 null, 
                Long.parseLong(jo.getString("studentnummer")), 
                jo.getString("studierichting"),
                jo.getString("studiejaar")
            );

            JSONArray total = jo.getJSONArray("vakkenpakket");
            JSONArray open = jo.getJSONArray("behaalde_cijfers");
            
            List<CourseSubject> subjects = new LinkedList<CourseSubject>();
            
            for (int j = 0; j < total.length(); j++) {
                JSONObject subject = total.getJSONObject(j);
                double grade = 0;
                
                for (int c = 0; c < open.length(); c++) {
                    if (open.getJSONObject(c).getString("vakcode").equals(subject.getString("vakcode"))) {
                        grade = open.getJSONObject(c).getDouble("cijfer");
                        break;
                    } else {
                        grade = 0;
                    }
                }

                CourseSubject cs = new CourseSubject(
                    subject.getString("vakcode"),
                    subject.getString("naam"),
                    0,
                    2,
                    grade
                );

                subjects.add(cs);
            }

            t.setTotalSubjects(subjects);

            if (Administration.ListOfStudents.containsKey(jo.getString("studierichting"))) {
                Administration.ListOfStudents.get(jo.getString("studierichting")).add(t);
            } else {
                List<Student> students = new LinkedList<Student>();
                students.add(t);
                Administration.ListOfStudents.insert(jo.getString("studierichting"), students);
            }
        }


    
        // administration.printStudentsByGroup("Technische Informatica", "TI2.1");
        // administration.printStudentsBySubject("Technische Informatica", "TI-ARCH");
        // administration.printStudentSubjectList("Biologie", "Sophie van der Meer");
        
        
        bootscreen();
        Scanner scanner = new Scanner(System.in);
        while (!_stopProgram) {
            switch (page)
                {
                case "A":
                    System.out.println("\t\t");
                    System.out.println("\t\t---- Studenten in een klas ----");
                    System.out.println("\t\t");
                    scanner = new Scanner(System.in);
                    System.out.print("Voer de opleiding in: ");
                    String c = scanner.nextLine();

                    System.out.print("Voer de klas in: ");
                    scanner = new Scanner(System.in);
                    String g = scanner.nextLine();

                    administration.printStudentsByGroup(c, g);
                    break;
                case "B":
                    System.out.println("\t\t");
                    System.out.println("\t\t---- Studenten van een vak ----");
                    System.out.println("\t\t");
                    scanner = new Scanner(System.in);
                    System.out.print("Voer de opleiding in: ");
                    c = scanner.nextLine();

                    System.out.print("Voer het vak in: ");
                    scanner = new Scanner(System.in);
                    g = scanner.nextLine();

                    administration.printStudentsBySubject(c, g);
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
                    System.out.println("\t\t");
                    System.out.println("\t\t---- Student vakkenpakket ----");
                    System.out.println("\t\t");
                    scanner = new Scanner(System.in);
                    System.out.print("Voer de opleiding in: ");
                    c = scanner.nextLine();

                    System.out.print("Voer naam student in: ");
                    scanner = new Scanner(System.in);
                    g = scanner.nextLine();

                    administration.printStudentSubjectList(c, g);
                    break;
                case "Q":
                    _stopProgram = true;
                    break;
                default:

                    break;
            }

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
        System.out.println("I) Student vakkenpakket"); 
        System.out.println("Q) Afsluiten");

        System.out.print("Toets uw character: ");
        scanner = new Scanner(System.in);

        page = scanner.nextLine();
        }

        scanner.close();
    }


    static public void bootscreen()
    {
        System.out.println("\n\n\n\n\n\n");
        System.out.println("\t\t\t\t\t\t _____     _                          _              _            ");
        System.out.println("\t\t\t\t\t\t(  _  )   ( )          _       _     ( )_           ( )_ _        ");
        System.out.println("\t\t\t\t\t\t| (_) |  _| | ___ ___ (_) ___ (_) ___|  _)_ __   _ _|  _)_)  __   ");
        System.out.println("\t\t\t\t\t\t(  _  )/ _  |  _   _    |  _    |  __) | (  __)/ _  ) | | |/ __   ");
        System.out.println("\t\t\t\t\t\t| | | | (_| | ( ) ( ) | | ( ) | |__    |_| |  ( (_| | |_| |  ___/ ");
        System.out.println("\t\t\t\t\t\t(_) (_) __ _)_) (_) (_)_)_) (_)_)____/ __)_)    __ _) __)_)  ___) ");  
        System.out.println("\n\n\n");
        System.out.println("\t\t\t\t\t\tCopyright: Niko van Ommen - 1030808 - 2023");
        System.out.println("\n\n\n");
    }
}