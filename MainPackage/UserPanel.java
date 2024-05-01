package MainPackage;

import Person.*;
import Inforamtion.*;

public class UserPanel {
    Person user;
    public static Information[] information;
    private static int informationAmount;

    static {
        information = new Information[10];
        information[0] = new Information("code 122 of math tomorrow is cancle, good lock.");//defaulte information
        information[1] = new Information("in 3nd of june at 'A' edge will hold a conferanse around 2 hours for computer engeeniers");//defaulte information
        informationAmount = 2;
    }

    //constructor
    public UserPanel(Person user) {
        this.user = user;
    }

    //methods
    public void showPanelStatus() throws InterruptedException {
        //نباید این ها اینجا باشند...باید برای هر یوزر تسک های جداگانه ای وجود داشته باشد
        user.addNewHomeWork("phicis", 12.01, 23.59);
        user.addNewExam("math", 14.30, 16.00);
        user.addNewQuiz("computer", 6.00, 20.00);
        //--------------------------------------------------------------------------------------
        user.printProfile();
        user.printTasks();
        user.printInformation();
    }

    public static void addNewInformation(String information_passage) {
        information[informationAmount] = new Information(information_passage);
        informationAmount++;
    }

    public static int getInformationAmount() {
        return informationAmount;
    }       
    
}
