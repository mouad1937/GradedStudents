package io.zipcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private Student [] students;

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents){
        this.students= new Student[maxNumberOfStudents];
    }

    public Classroom(){
        this.students=new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore(){
        if (students.length == 0) {
            return 0.0;
        }
        double sum =0.0;
        for (Student student :students){
            sum += student.getAverageExamScore();
        }

        return sum / getNumberOfStudents(); // return sum / getNumberOfExamTaken;
    }

    public int getNumberOfStudents(){
        int x=0;
        for (Student student: students){
            if(student != null) {
                x++;
            }
        }
        return x;
    }

    public  void addStudent(Student student){
    for (int i=0;i<students.length;i++){
        if (students[i]==null){ //before adding any student , we need to check if there's any available seat.
            students[i]=student;
            return;
        }
    }
        System.out.println("full Classroom");
    }

    public void removeStudent(String firstName , String lastName){
     for (int a =0;a<students.length;a++){
        Student student =students[a];
         if (student!=null&student.getFirstName().equals(firstName)&&student.getLastName().equals(lastName));
        students[a]=null;
        reorderStudents();
        return;
      }
        System.out.println("Student not found");
    }
    public void reorderStudents(){//    // Helper method to reorder students and move null values to the end

        int nullIndex=students.length-1;
    for (int i =0;i<nullIndex;i++){
        if (students[i]==null){
            while (students[nullIndex]==null&&nullIndex>i){
                nullIndex--;
            }
            students[i]=students[nullIndex];
            students[nullIndex]=null;
        }
    }
    }
    public Student[] getStudentsByScore(){
        Student[]sortedStudents= Arrays.copyOf(students,students.length);
        Arrays.sort(sortedStudents,(s1,s2)->{
            if (s1==null&&s2==null){
                return 0;
            } else if (s1==null) {
                return 1;
            } else if (s2==null) {
                return -1;
            }else {
                int compareScore=Double.compare(s1.getAverageExamScore(),s2.getAverageExamScore());
                if (compareScore==0){
                    int lexiComparison=s1.getLastName().compareTo(s2.getLastName());
                if (lexiComparison==0){
                    return s1.getFirstName().compareTo(s2.getFirstName());
                }
                return lexiComparison;
                }
                return compareScore;
            }

        });
        return sortedStudents;
    }

    public Map<Student,Character> getGradeBook(){
        Map<Student,Character>gradeBook=new HashMap<>();
        int totalStudents=0;
        for (Student student: students){
            if (student!=null){
                totalStudents++;
            }
        }
        int upper10thPercentile=(int)Math.ceil(totalStudents*0.1);
        int upper11thPercentile=(int)Math.ceil(totalStudents*0.11);
        int upper29thPercentile=(int)Math.ceil(totalStudents*0.29);
        int upper30thPercentile=(int)Math.ceil(totalStudents*0.3);
        int upper50thPercentile=(int)Math.ceil(totalStudents*0.5);
        int lower11thPercentile=(int)Math.ceil(totalStudents*0.89);

        Student[]sortStudent=getStudentsByScore();


        for (int i=0;i<totalStudents;i++){
            Student student= sortStudent[i];
            double averageScr=student.getAverageExamScore();
            if (i < upper10thPercentile) {
                gradeBook.put(student, 'A');
            } else if (i < upper30thPercentile) {
                gradeBook.put(student, 'B');
            } else if (i < upper50thPercentile) {
                gradeBook.put(student, 'C');
            } else if (i < lower11thPercentile) {
                gradeBook.put(student, 'D');
            } else {
                gradeBook.put(student, 'F');
            }
        }
return gradeBook;
    }









}
