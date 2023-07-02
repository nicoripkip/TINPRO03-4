package administration;

import subject.CourseSubject;
import util.Hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import person.Student;


/**
 * @author Nico van Ommen | 1030808
 * @since 02/07/2023
 */
public class Administration 
{
    public static Hashtable<String, List<Student>> ListOfStudents = new Hashtable<String, List<Student>>();


    /**
     * Method to print a list of students by a given group
     * 
     * @param group
     */
    public void printStudentsByGroup(String course, String group)
    {
        if (ListOfStudents.get(course) == null) {
            System.out.print("Sorrie, Klas niet gevonden!");
            return;
        }

        List<Student> students = ListOfStudents.get(course).stream()
            .filter(c -> c.getGroup().equals(group))
            .collect(Collectors.toList());

        for (int i = 0; i < students.size(); i++) {
            students.get(i).Display();
        }
    }


    /**
     * Method to print a list of students by a given subject
     * 
     * @param course
     * @param subjet
     */
    public void printStudentsBySubject(String course, String subject)
    {
        if (ListOfStudents.get(course) == null) {
            System.out.print("Sorrie, vak niet gevonden!");
            return;
        }

        List<Student> students = ListOfStudents.get(course).stream()
            .filter(c -> c.getTotalSubjects().stream()
                .anyMatch(x -> x.getCourseCode().equals(subject)))
            .collect(Collectors.toList());

        for (int i = 0; i < students.size(); i++) {
            students.get(i).Display();
        }
    }


    /**
     * Method to print all students subject list
     * 
     * @param course
     * @param student
     */
    public void printStudentSubjectList(String course, String name)
    {
        if (ListOfStudents.get(course) == null) {
            System.out.print("Sorrie, student niet gevonden!");
            return;
        }

        List<CourseSubject> subjects = ListOfStudents.get(course).stream()
            .filter(x -> x.getName().equals(name))
            .findAny()
            .map(Student::getTotalSubjects)
            .orElse(new ArrayList<CourseSubject>());
        
        System.out.println("\t\t\t" + name + "'s vakken: ");
        for (CourseSubject cs : subjects) {
            cs.display();
        }
    }


    /**
     * Method to print all the students open subjects
     * 
     * @param student
     */
    public void printStudentOpenSubjects(String course, String name)
    {
        if (ListOfStudents.get(course) == null) {
            System.out.print("Sorrie, Student niet gevonden!");
            return;
        }

        List<CourseSubject> subjects = ListOfStudents.get(course).stream()
            .filter(x -> x.getName().equals(name))
            .flatMap(x -> x.getTotalSubjects().stream())
            .filter(y -> y.getGrade() < 5.5)
            .collect(Collectors.toList());
        
        int total = 0;
        for (CourseSubject cs : subjects) {
            cs.display();
            total++;
        }

        System.out.println("\nTotaal: " + total + " vakken staan nog open");
    }


    /**
     * Method to print all the students finished subjects
     * 
     * @param course
     * @param name
     */
    public void printStudentFinishedSubjects(String course, String name)
    {
        if (ListOfStudents.get(course) == null) {
            System.out.print("Sorrie, Student niet gevonden!");
            return;
        }

        List<CourseSubject> subjects = ListOfStudents.get(course).stream()
            .filter(x -> x.getName().equals(name))
            .flatMap(x -> x.getTotalSubjects().stream())
            .filter(y -> y.getGrade() > 5.5)
            .collect(Collectors.toList());
        
        int total = 0;
        for (CourseSubject cs : subjects) {
            cs.display();
            total++;
        }

        System.out.println("\nTotaal: " + total + " vakken afgesloten");
    }


    /**
     * Method to print the average grade of the student who finished the subject
     * 
     * @param course
     * @param subject
     */
    public void printStudentGradeAverage(String course, String subject)
    {
        if (ListOfStudents.get(course) == null) {
            System.out.print("Sorrie, Vak niet gevonden!");
            return;
        }

        double average = ListOfStudents.get(course).stream()
            .flatMap(x -> x.getTotalSubjects().stream())
            .filter(y -> y.getCourseCode().equals(subject))
            .collect(Collectors.toList())
            .stream()
            .filter(x -> x.getGrade() > 5.5)
            .mapToDouble(CourseSubject::getGrade)
            .sum();

        double total = ListOfStudents.get(course).stream()
            .flatMap(x -> x.getTotalSubjects().stream())
            .filter(y -> y.getCourseCode().equals(subject))
            .count();


        System.out.println("Gemiddelde cijfer voor het vak: " + average/total);
    }


    /**
     * Method
     * 
     * @param course
     * @param subject
     */
    public void printStudentWeightedAverage(String course, String name)
    {
        if (ListOfStudents.get(course) == null) {
            System.out.print("Sorrie, student niet gevonden!");
            return;
        }

        List<CourseSubject> subjects = ListOfStudents.get(course).stream()
            .filter(x -> x.getName().equals(name))
            .findAny()
            .map(Student::getTotalSubjects)
            .orElse(new ArrayList<CourseSubject>());

        double average = subjects.stream()
            .mapToDouble(CourseSubject::getGrade)
            .sum();

        int totalECs = subjects.stream()
            .filter(x -> x.getGrade() > 5.5)
            .mapToInt(CourseSubject::getECs)
            .sum();

        double total = subjects.stream()
            .count();
        
        System.out.println("Gemiddelde resultaat van de student: " + average/total);
        System.out.println("Totaal aan gehaalde ECs: " + totalECs);
    }


    /**
     * 
     * 
     * @param course
     * @param subject
     */
    public void printPercentageStudentFinishedSubject(String course, String subject)
    {
        if (ListOfStudents.get(course) == null) {
            System.out.print("Sorrie, Vak niet gevonden!");
            return;
        }
    }


    public void printStudentProgress(Student student)
    {

    }


    public static Hashtable<String, List<Student>> getHashtable()
    {
        return ListOfStudents;
    }
}
