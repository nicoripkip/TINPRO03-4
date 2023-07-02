package administration;

import subject.CourseSubject;
import util.Hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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


    public void printStudentOpenSubjects(Student student)
    {

    }


    public void printStudentFinishedSubjects(Student student)
    {

    }


    public void printStudentGradeAverage(Student student)
    {

    }


    public void printStudentWeightedAverage(Student student)
    {

    }


    public void printPercentageStudentFinishedSubject(Student student)
    {

    }


    public void printStudentProgress(Student student)
    {

    }


    public static Hashtable<String, List<Student>> getHashtable()
    {
        return ListOfStudents;
    }
}
