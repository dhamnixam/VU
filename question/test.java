package question;

import java.util.Scanner;

public class test extends question {
    public String[] options = new String[4];
    public int answer;

    public test(String title, String one, String two, String three, String four, int answer) {
        this.title = title;
        this.options[0] = one;
        this.options[1] = two;
        this.options[2] = three;
        this.options[3] = four;
        this.answer = answer;
    }

    public void showTest() {
        System.out.println(title);
        System.out.println("1." + options[0]);
        System.out.println("2." + options[1]);
        System.out.println("3." + options[2]);
        System.out.println("4." + options[3]);
    }

    public int getAnswer() {
        Scanner input = new Scanner(System.in) ;
        int i;
        System.out.println("pls Enter your Answer : ");
        i = input.nextInt();
        while (i < 1 || i > 4) {
            System.out.println("pls Enter 1 2 3 4 :");
            i = input.nextInt();
        }
    return  i ;
    }
    public boolean isAnswerCorrect(){
        if (getAnswer()==answer) return true;
        else return false;
    }
}
