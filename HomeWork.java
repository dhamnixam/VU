public class HomeWork extends Task{

    public HomeWork(String subject, double start_time, double end_time) {
        super(subject, start_time, end_time);
    }

    @Override
    public String toString() {
        return "Home work:\n" + "start at " + timeToString(start_time) + "\n" + "end at " + timeToString(end_time);
    }
    
}
