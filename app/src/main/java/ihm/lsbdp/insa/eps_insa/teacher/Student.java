package ihm.lsbdp.insa.eps_insa.teacher;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by benjiros on 20/11/2017.
 */

public class Student {

    private String name;
    private String lastName;

    public static List<Student> students = new ArrayList<>();


    public static void loadStudent() {
        students.add(new Student("Benjamin", "Ros"));
        students.add(new Student("Vincent","Piet"));
    }

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
       }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }




}