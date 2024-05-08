package Notification;

public class Notification {

    private String passage;

    public Notification(String info_passage) {
        setPassage(info_passage);
    }

    public void setPassage(String passage) {
        if (passage.isEmpty() == false)
            this.passage = passage;
        else
            this.passage = "Empty passage";
    }

    public String getPassage() {
        return this.passage;
    }

    public String toString() {
        return "Notification:\n" + this.passage;
    }

}
