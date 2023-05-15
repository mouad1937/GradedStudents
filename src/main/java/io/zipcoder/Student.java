package io.zipcoder;

import java.util.ArrayList;
public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double>examScores;


    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        for (double score:examScores) {
             this.examScores.add(score);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }
    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }
    public void setExamScore(int examNumber, double newScore){
        examScores.set(examNumber,newScore);
    }

    public double getAverageExamScore(){
        if (examScores.isEmpty()){
            return 0.0;
        }
        double sum =0.0;
        for (Double scr:examScores){
            sum += scr;
        }

        return sum / examScores.size(); // return sum / getNumberOfExamTaken;
    }
    @Override
    public String toString() {
        return "Student Name='" + firstName + lastName+  '\'' +
                "> Average Score: "+ getAverageExamScore()+'\'' +
                "> Exam Scores=" + getExamScores()
                ;
    }
}
