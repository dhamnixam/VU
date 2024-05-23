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
        String str = "";
        str += "Type: Exam\n";
        str += "Started at: " + timeToString(start_time) + "\n";
        str += "End at: " + timeToString(end_time) + "\n";
        if (getCurrentTime() > end_time) {
            str += "Situation: " + "expired";
        }
        else {
            str += "Situation: " + "unexpired";
        }
        return str;
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
