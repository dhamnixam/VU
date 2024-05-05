package MainPackage;

import Person.*;
import Inforamtion.*;
import java.util.Scanner;

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
    public UserPanel(Person user) throws InterruptedException {
        this.user = user;
        main_tab();
    }

    //methods
    public void showPanelStatus() throws InterruptedException {
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

    private void task_tab() throws InterruptedException {
        System.out.println("---TASK TAB---");
        Scanner in = new Scanner(System.in);
        String command = "";
        while (!command.equals("back")) {
            System.out.println("write [add] to add a new task");
            Thread.sleep(750);
            System.out.println("write [remove] to remove task");
            Thread.sleep(750);
            System.out.println("write [back] to back");
            command = in.next();
            switch (command) {
                case "add":
                    addTask_tab();
                    break;
                case "remove":
                    removeTask_tab();
                    break;
            
                default:
                    break;
            }
        }
        main_tab();
    }

    private void addTask_tab() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String command = "";
        while (!command.equals("back")) {
            System.out.println("[quiz] to add quiz");
            Thread.sleep(750);
            System.out.println("[exam] to add exam");
            Thread.sleep(750);
            System.out.println("[homework] to add home work");
            Thread.sleep(750);
            System.out.println("[back] to back");
            command = in.next();

            if (command.equals("back")) {
                task_tab();
                return;
            }

            System.out.print("subject: ");
            String subject = in.nextLine(); //this nextLine doesn't work
            subject = in.nextLine();
            System.out.print("start time (use flote nubmer for time like 14.15): ");
            double start_time = in.nextDouble();
            System.out.print("finish time: ");
            double finish_time = in.nextDouble();
            System.out.print("number of questions: ");
            int numbers = in.nextInt();

            switch (command) {
                case "quiz":
                    ((Teacher)user).addNewQuiz(subject, start_time, finish_time);//باید این متد را در اذمین هم پیاده سازی کنیم
                    break;
                case "exam":
                    ((Teacher)user).addNewExam(subject, start_time, finish_time ,numbers);
                    break;
                case "homework":
                    ((Teacher)user).addNewHomeWork(subject, start_time, finish_time);
                    break;
            
                default:
                    break;
            }
            Thread.sleep(1000);
        }
        task_tab();
    }

    private void removeTask_tab() throws InterruptedException {
        String command = "";
        Scanner in = new Scanner(System.in);
        while (true) {
            ((Teacher)user).removeTask();
            System.out.println("[remove] to remove another student: ");
            Thread.sleep(750);
            System.out.println("[back] to back: ");
            command = in.next();

            if (command.equals("back")) 
                break;
        }
        task_tab();
    }

    
    private void main_tab() throws InterruptedException {
        System.out.println("---MAIN TAB---");
        int command = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Witch tab do you want?");
        Thread.sleep(1000);
        while (command != 0) {
            System.out.println("tasks : 1");
            Thread.sleep(750);
            System.out.println("univercitys information : 2");
            Thread.sleep(750);
            System.out.println("your profile : 3");
            Thread.sleep(750);
            System.out.println("exit : 0");
            Thread.sleep(750);
            System.out.print("Type a number here: ");
            command = in.nextInt();
            switch (command) {
                case 1:
                    user.printTasks();
                    if (!(user instanceof Student)) {
                        task_tab();
                    }
                    break;
                case 2:
                    user.printInformation();
                    break;
                case 3:
                    user.printProfile();
                    break;
                                
                default:
                    System.out.println("Input is invalid!");
                    break;
            }
        }
    }
    
}
