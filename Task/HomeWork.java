package Task;


public class HomeWork extends Task{

    private String answer = "";

    public HomeWork(String subject, double start_time, double end_time) {
        super(subject, start_time, end_time);
    }

    @Override
    public String toString() {
        String str = "";
        str += "Type: Home work\n";
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

    public void setAnswer(String answer) {
        if (answer.isEmpty()) 
            this.answer = "srudent did not answered";
        else 
            this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }
    
}
