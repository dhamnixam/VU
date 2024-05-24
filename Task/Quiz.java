package Task;

import java.util.Scanner;

public class Quiz extends Task{

    private String question = "";
    private String answer = "";

    public Quiz(String subject, double start_time, double end_time) {
        super(subject, start_time, end_time);
    }

    @Override
    public String toString() {
        String str = "";
        str += "Type: Quiz\n";
        str += "Started at: " + timeToString(start_time) + "\n";
        str += "End at: " + timeToString(end_time) + "\n";
        str += "Situation: ";
        if (getCurrentTime() <= start_time) {
            str += "unexpired\n";
            str += Double.toString((start_time - getCurrentTime())) + " left to start";
        }
        else if (getCurrentTime() > end_time) {
            str += "expired\n";
            str += Double.toString((getCurrentTime() - end_time)) + " passed";
        }
        else if (getCurrentTime() <= end_time){
            str += "unexpired\n";
            str += Double.toString((end_time - getCurrentTime())) + " left to end";
        }
        return str;
    }

    public void setQuestion(String question) {
        if (question.isEmpty() == false) 
            this.question = question;
        else {
            System.out.println("Are you sure to set this question blanck?(y/n)");
            Scanner in = new Scanner(System.in);
            String yes_no = in.next();
            switch (yes_no) {
                case "y":
                    this.question = "this question did not set! so don't answer it";
                    break;
                case "n":
                    System.out.print("Set your question again: ");
                    setQuestion(in.next());
                    break;
            
                default:
                    break;
            }
        }
            
    }

    public void setAnswer(String answer) {
        if (question.isEmpty()) 
            this.answer = answer;

        else if (question.isEmpty() == false && answer.isEmpty() == false) 
            this.answer = answer;

        else 
            this.answer = "srudent did not answered to this question";
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }
    
}
