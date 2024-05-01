package question;

import java.util.Scanner;

public class descriptive extends question{
    private String answer ;

    public descriptive(String title){
        this.title = title;
    }
    public void SetAnswer(){
        Scanner input = new Scanner(System.in) ;
        answer = input.next();
    }
    public String getAnswer(){
        return answer;
    }
}
