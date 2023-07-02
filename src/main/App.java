package main;


import window.Window;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import person.Student;
import subject.CourseSubject;
import util.Reader;
import org.json.*;
import util.Hashtable;
import util.KeyPair;
import administration.Administration;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
public class App
{
    private static final String BASE_STRING = "file:///C:/Users/Nicki/Documents/Projecten/Java/TINPRO03-4/";
    // private static final String BASE_STRING = "file:///home/niko/Documenten/Projecten/Java/TINPRO03-4/";


    /**
     * Methode voor het starten van het programma
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception 
    {
        Window window = new Window();
        window.bootscreen();

        Administration administration = new Administration();

        String data = Reader.getDataFromFile(BASE_STRING + "studentData.json");
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

        // for (KeyPair<String, List<Student>> l : ListOfStudents.getValues()) {
        //     if (l != null) {
        //         for (int i = 0; i < l.getValue().size(); i++) {
        //             l.getValue().get(i).Display();
        //         }
        //     }
        // }
    
        administration.printStudentsByGroup("IT1.1");
    }
}
