package Informaion;

public class Informaion {

    private String passage;

    public Informaion(String info_passage) {
        setPassage(info_passage);
    }

    public void setPassage(String passage) {
        if (!passage.isEmpty())
            this.passage = passage;
        else
            this.passage = "Empty passage";
    }

    public String getPassage() {
        return this.passage;
    }

    public String toString() {
        return this.passage;
    }

}
