package MainPackage;

import Exceptions.InvalidIDException;
import java.util.Scanner;
import Person.Teacher;

public class Main {
    public static void main(String[] args) throws InterruptedException , InvalidIDException {
                
        System.out.println("Do you have account? if yes press y else press any key");
        Teacher t = new Teacher();

        t.setID_number("147258");
        t.setPassword("Mm147258");

        SighUp.addNewPerson(t);

        LoginPage loginPage = new LoginPage();
        loginPage.loginMessages();

        // Scanner in = new Scanner(System.in);

        // if (in.next().equals("y")) {
        //     try {
        //         LoginPage loginPage = new LoginPage();
        //         loginPage.loginMessages();
        //     }
        //     catch (InvalidIDException e){
        //         System.out.println(e.getMessage());
        //     }
        //     finally {
        //         System.out.println("ID Processed");
        //     }
        // }
        // else {
        //     try {
        //         SighUp signUp = new SighUp();
        //         signUp.signUpMessages();
        //         LoginPage loginPage = new LoginPage();
        //         loginPage.loginMessages();
        //     }
        //     catch (InvalidIDException e ){
        //         System.out.println(e.getMessage());
        //     }
        //     finally {
        //         System.out.println("ID Processed");
        //     }
        // }

        
    }
}