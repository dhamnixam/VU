package MainPackage;

import Person.Teacher;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Teacher t = new Teacher();

        t.setID_number("147258");
        t.setPassword("Mm147258");

        SighUp.addNewPerson(t);

        LoginPage loginPage = new LoginPage();
        loginPage.loginMessages();


                
        // System.out.println("Do you have account? if yes press y else press any key");
        // Scanner in = new Scanner(System.in);

        // if (in.next().equals("y")) {
        //     LoginPage loginPage = new LoginPage();
        //     loginPage.loginMessages();
        // }
        // else {
        //     SighUp signUp = new SighUp();
        //     signUp.signUpMessages();
        //     LoginPage loginPage = new LoginPage();
        //     loginPage.loginMessages();
        // }

        
    }
}
