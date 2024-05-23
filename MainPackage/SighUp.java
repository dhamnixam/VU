package MainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import Exceptions.InvalidIDException;
import Person.*;

public class SighUp {

    public static Person[] persons;
    private static int persons_counter = 0;

    private Person user;

    static {
        persons = new Person[10];
    }


    public void signUpMessages() throws InterruptedException , InvalidIDException , InputMismatchException {
        String repeat_password;
        boolean sw = false;
        String errorMessage = "your input is invalid!";
        Scanner in = new Scanner(System.in);

        System.out.println("---SIGNUP PAGE---");
        Thread.sleep(1000);
        System.out.println("Enter these information...");

        do {
            int role;
            try {
                System.out.println("Your role: ");
                System.out.println("student = 1");
                System.out.println("teacher = 2");
                System.out.println("admin = 3");
                role = in.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println(errorMessage);
                in.next();
                continue;
            }
            if (role == 1 || role == 2 || role == 3) {
                sw = true;
                switch (role) {
                    case 1:
                        user = new Student();
                        break;

                    case 2:
                        user = new Teacher();
                        break;

                    case 3:
                        user = new Admin();
                        break;

                    default:
                        break;
                }
            }
            else
                System.out.println(errorMessage);
        } while (!sw) ;
        in.nextLine();  //fix the bug of get an extra line from user
        sw = false;

        do {
            System.out.print("name: ");

            if (user.setName(in.nextLine()))
                sw = true;
            else
                System.out.println(errorMessage);

        } while (!sw) ;
        sw = false;
        do {
            System.out.print("last name: ");
            if (user.setLastName(in.nextLine()))
                sw = true;
            else
                System.out.println(errorMessage);
        } while (!sw) ;
        sw = false;


        do {
            System.out.print("username: ");
            if (user.setUsername(in.nextLine()))
                sw = true;
            else
                System.out.println(errorMessage);
        } while (!sw) ;
        sw = false;


        do {
            System.out.print("field: ");
            if (user.setField(in.nextLine()))
                sw = true;
            else
                System.out.println(errorMessage);
        } while (!sw) ;
        sw = false;


        do {
        System.out.print("ID number: ");
            if (user.setID_number(in.nextLine()))
                sw = true;
            else
                System.out.println(errorMessage);
        } while (!sw) ;
        sw = false;


        do {
            System.out.print("email: ");
            if (user.setEmail(in.nextLine()))
                sw = true;
            else
                System.out.println(errorMessage);
        } while (!sw) ;
        sw = false;


        do {
            System.out.print("phone number: ");
            if (user.setPhoneNumber(in.nextLine()))
                sw = true;
            else
                System.out.println(errorMessage);
        } while (!sw) ;
        sw = false;

        do {
            System.out.print("password: ");
            if (user.setPassword(in.nextLine()))
                sw = true;
            else
                System.out.println(errorMessage);
        } while (!sw) ;
        sw = false;


        do {
            System.out.print("repeat password: ");
            repeat_password = in.nextLine();
            if (Utils.isPasswordValid(repeat_password) && repeat_password.equals(user.getPassword()))
                sw = true;
            else
                System.out.println(errorMessage); 
        } while (!sw) ;

        addNewPerson(user);
    }

    private static void addNewPerson(Person user) throws InterruptedException {
        if (user instanceof Student) {
            persons[persons_counter] = (Student)user;
        }
        else if (user instanceof Teacher) {
            persons[persons_counter] = (Teacher)user;
        }
        else if (user instanceof Admin) {
            persons[persons_counter] = (Admin)user;
        }

        persons_counter++;
        System.out.println("--------------------------");
        System.out.println("Your account created successfuly");
        System.out.println("--------------------------");
        Thread.sleep(1000);
    }
}
