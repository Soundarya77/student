import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student {

String name;
int id;
double cgpa;    

public Student(String name, int id, double cgpa) 
{
    this.name = name;
    this.id = id;
    this.cgpa = cgpa;
}

public String getName() {
    return name;
}

public int getId() {
    return id;
}

public double getCgpa() {
    return cgpa;
}
}

class Priorities {

List<Student> getStudents(List<String> events) 
{
    String ch="";
    String name="";
    int id=0;
    double cgpa=0;
    int n=1;
    String newTest="";
    sort sort1=new sort();
    List<Student>  s1=new ArrayList<Student>();      
    for (int i = 0; i < events.size(); i++) 
    {
        if(events.get(i).charAt(0)=='S')
        {
            if(s1.isEmpty())
                continue;
            s1.sort(sort1);
            s1.remove(0);
            continue;
        }
        else
        {
            newTest=events.get(i).substring(6);
        }    

        for (int j = 0; j < newTest.length(); j++) 
        {
            if(newTest.charAt(j)==' '||j==newTest.length()-1){
                if(n==1){
                    name=ch;
                    n++;
                    ch="";
                    continue;
                }
                 if(n==2)
                 {
                    cgpa=Double.parseDouble(ch);
                    n++;
                    ch="";
                    continue;
                }
                  if(n==3)
                  {
                    id=Integer.parseInt(ch);
                    n=1;
                    ch="";
                    continue;
                }

            }
            ch=ch+newTest.charAt(j);


        }
        ch="";
        s1.add(new Student(name,id,cgpa));

    }
    s1.sort(sort1);
    return s1;
} 
}

class sort implements java.util.Comparator < Student > {

public int compare(Student t, Student t1) {
   if(Double.compare(t1.cgpa, t.cgpa)==0){
       if(t1.getName()==t.getName())
           return t1.getId()-t.getId();
   else
           return t.getName().compareTo(t1.getName());
   }
   else
       return t.getCgpa()>t1.cgpa ? -1:1;  
} }

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}