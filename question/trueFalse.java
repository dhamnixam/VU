package question;

import java.util.Scanner;

public class trueFalse extends question{
    private final boolean  answer ;

    public trueFalse(String title, boolean answer) {
        this.title = title;
        this.answer = answer;
    }
    public void showTrueFalse() {
        System.out.println(title);
    }

    public boolean getAnswer() {
        Scanner input = new Scanner(System.in) ;
        boolean i;
        System.out.println("pls Enter your Answer : ");
        i = input.nextBoolean();
        while (!input.hasNextBoolean()) {
            System.out.println("pls Enter boolean :");
            i = input.nextBoolean();
        }
        return i ;
    }
    public boolean isAnswerCorrect(){
        return getAnswer() == answer;
    }
}
