package main;


import window.Window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import person.Student;
import subject.CourseSubject;
import util.Reader;
import org.json.*;


/**
 * @author Nico van Ommen | 1030808
 * @since 04/27/2022
 */
public class App
{
    // private static final String BASE_STRING = "file:///C:/Users/Nicki/Documents/Projecten/Java/TINPRO03-4/";
    private static final String BASE_STRING = "file:///home/niko/Documenten/Projecten/Java/TINPRO03-4/";


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

        String data = Reader.getDataFromFile(BASE_STRING + "studentData.json");

        // System.out.println(Colors.PRINT_INFO + data);

    
        Map<String, List<Student>> ListOfStudents = new HashMap<String, List<Student>>();

        JSONArray ja = new JSONArray(data);

        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);

            Student t = new Student(
                jo.getString("naam"), 
                jo.getString("naam"), 
                 null, 
                Long.parseLong(jo.getString("studentnummer")), 
                jo.getString("studierichting"),
                jo.getString("studiejaar")
            );

            JSONArray total = jo.getJSONArray("vakkenpakket");

            List<CourseSubject> subjects = new LinkedList<CourseSubject>();
            JSONArray open = jo.getJSONArray("behaalde_cijfers");
            int c = 0;
            for (int j = 0; j < total.length(); j++) {
                JSONObject subject = total.getJSONObject(j);
                float grade = 0;

                System.out.println();

                if (open.getJSONObject(c).getString("vakcode") == subject.getString("vakcode")) {
                    grade = Float.parseFloat(open.getJSONObject(c).getString("cijfer"));
                    c++;
                } else {
                    grade = 0;
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

            if (ListOfStudents.containsKey(jo.getString("studierichting"))) {
                ListOfStudents.get(jo.getString("studierichting")).add(t);
            } else {
                List<Student> students = new LinkedList<Student>();
                students.add(t);
                ListOfStudents.put(jo.getString("studierichting"), students);
            }
        }

        for (Map.Entry<String, List<Student>> entry : ListOfStudents.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                entry.getValue().get(i).Display();
            }
        }
    }
}
