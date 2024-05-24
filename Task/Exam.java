package Task;

import java.util.Scanner;

import question.* ;

public class Exam extends Task{
    private question[] questions ;
    private int counter = 0 ;
    // private String[] answers;


    public Exam(String subject, double start_time, double end_time , int number_of_qusetions) {
        super(subject, start_time, end_time);
        questions = new question[number_of_qusetions];
        // answers = new String[number_of_qusetions];
    }

    @Override
    public String toString() {
        String str = "";
        str += "Type: Exam\n";
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

    public void addTest(){
        Scanner in = new Scanner(System.in);
        System.out.print("Set title:");
        String title = in.nextLine();
        System.out.print("Set passage of 1st option:");
        String one = in.nextLine();
        System.out.print("2nd option:");
        String two = in.nextLine();
        System.out.print("3rd option:");
        String three = in.nextLine();
        System.out.print("4th option:");
        String four = in.nextLine();
        int answer = 1;
        while (true) {
            System.out.print("and which one is the answer? inseart it's number: ");
            answer = in.nextInt();
            if (answer > 0 && answer < 5)
                break;
            else 
                System.out.println("input is invalid");
        }
    
        questions[counter]= new test(title, one, two, three, four, answer);
        counter++;
    }

    public void addTrueFalse(){
        Scanner in = new Scanner(System.in);
        System.out.print("Set title:");
        String title = in.nextLine();
        System.out.print("Set answer, press 1 to true and 2 to false");
        boolean answer = true;
        boolean sw = true;
        while (sw) {
            switch (in.nextInt()) {
                case 1:
                    answer =true;
                    sw = false;
                    break;
                case 2:
                    answer = false;
                    sw = false;
                    break;
            
                default:
                    System.out.println("input is invalid, press 1 of 2: ");
                    break;
            }
        }
        
        questions[counter]= new trueFalse( title, answer);
        counter++;
    }

    public void addDescriptive(){
        Scanner in = new Scanner(System.in);
        System.out.print("Set title: ");
        String title = in.nextLine();
        questions[counter] = new descriptive(title);
        counter++;
    }

    // public void setAnswer(String answer, int index) {
    //     if (answer.isEmpty() == false) 
    //         answers[index] = answer;
    //     else
    //         answers[index] = "srudent did not answered";
        
    // }
}
