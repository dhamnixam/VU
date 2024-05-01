package Task;

public class Quiz extends Task{

    public Quiz(String subject, double start_time, double end_time) {
        super(subject, start_time, end_time);
    }

    @Override
    public String toString() {
        return "Quiz:\n" + "start at " + timeToString(start_time) + "\n" + "end at " + timeToString(end_time);
    }
    
}
