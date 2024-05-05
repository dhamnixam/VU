package Task;

import question.* ;

public class Exam extends Task{
    public question[] questions ;
    public int counter = 0 ;

    public Exam(String subject, double start_time, double end_time , int qusetions) {
        super(subject, start_time, end_time);
       questions = new question[qusetions];
    }

    @Override
    public String toString() {
        return "Exam:\n" + "start at " + timeToString(start_time) + "\n" + "end at " + timeToString(end_time);
    }

    public void addTest(String title, String one, String two, String three, String four, int answer){
        questions[counter]= new test(title, one, two,three, four,answer);
        counter++;

    }
    public void addTrueFalse(String title, boolean answer){
        questions[counter]= new trueFalse( title, answer);
        counter++;
    }
    public void addDescriptive(String title){
      questions[counter] = new descriptive(title);
        counter++;
    }
}
