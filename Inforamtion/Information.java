package Inforamtion;

public class Information {
    private String passage;
    
    public Information(String info_passage) {
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
        return "Inforamtion:\n" + this.passage;
    }

    
}
