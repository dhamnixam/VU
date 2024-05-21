package MainPackage;

import Person.*;

import java.util.Scanner;

import Informaion.*;

public class UserPanel {
    Person user;
    public static Informaion[] Informaion;
    private static int InformationAmount;

    static {
        Informaion = new Informaion[10];
        Informaion[0] = new Informaion("math-122 tomorrow is cancle, good lock.");//defaulte information
        Informaion[1] = new Informaion("in 3nd of june at 'A' edge will hold a conferanse around 2 hours for computer engeeniers");//defaulte information
        InformationAmount = 2;
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

    private static void addNewInformation(String information_passage) {
        Informaion[InformationAmount] = new Informaion(information_passage);
        InformationAmount++;
    }

    private void deleteInformation() throws InterruptedException {
        user.printInformation();
        Scanner in = new Scanner(System.in);
        System.out.println("Which one do you want to delete? press it's number.If you inseart an invalid number it will cancle");
        int index = in.nextInt() - 1;
        if (index >= 0 && index < InformationAmount) {
            Informaion[index] = null;
            for (int i = index; i + 1 < InformationAmount; i++) {
                Informaion[i+1] = Informaion[i];
            }
            InformationAmount--;
            System.out.println("Information deleted successfuly");
        }
        
    }

    private void deleteInformation(int index) throws InterruptedException {
        if (index >= 0 && index < InformationAmount) {
            Informaion[index] = null;
            for (int i = index; i + 1 < InformationAmount; i++) {
                Informaion[i+1] = Informaion[i];
            }
            InformationAmount--;
            System.out.println("Information deleted successfuly");
        }
        
    }

    public static int getInformationAmount() {
        return InformationAmount;
    }

    private void task_tab() throws InterruptedException {
        System.out.println("---TASK TAB---");
        Scanner in = new Scanner(System.in);
        String command = "";
        while (true) {
            System.out.println("write [add] to add a new task");
            Thread.sleep(750);
            System.out.println("write [remove] to remove task");
            Thread.sleep(750);
            System.out.println("write [back] to back");
            Thread.sleep(750);
            System.out.println("write [home] to main tab");
            command = in.next();
            switch (command) {
                case "add":
                    addTask_tab();
                    break;
                case "remove":
                    removeTask_tab();
                    break;
                case "back":
                user.printTasks();
                    break;
                case "home":
                    main_tab();
                    break;
            
                default:
                    break;
            }
        }
    }

    private void addTask_tab() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String command = "";
        while (true) {
            System.out.println("[quiz] to add quiz");
            Thread.sleep(750);
            System.out.println("[exam] to add exam");
            Thread.sleep(750);
            System.out.println("[homework] to add home work");
            Thread.sleep(750);
            System.out.println("[back] to back");
            Thread.sleep(750);
            System.out.println("[home] to main tab");
            
            command = in.next();

            if (command.equals("back")) {
                task_tab();
                return;
            }
            else if (command.equals("home")) {
                main_tab();
                return;
            }

            System.out.print("subject: ");
            String subject = in.nextLine(); //this nextLine doesn't work
            subject = in.nextLine();
            System.out.print("start time (use flote nubmer for time like 14.15:) ");
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
    }

    private void removeTask_tab() throws InterruptedException {
        String command = "";
        Scanner in = new Scanner(System.in);
        while (true) {
            ((Teacher)user).removeTask();
            System.out.println("[remove] to remove another student: ");
            Thread.sleep(750);
            System.out.println("[back] to back: ");
            Thread.sleep(750);
            System.out.println("[home] to main tab: ");
            command = in.next();

            if (command.equals("back")) {
                task_tab();
                return;
            }
            else if (command.equals("home")) {
                main_tab();
                return;
            }
        }
    }


    private void information_mannager_tab() throws InterruptedException {
        System.out.println("---INFORMATION MANNAGER TAB---");
        System.out.println("Do you want to add a new information of delete some?");
        Thread.sleep(700);
        System.out.println("Press [a] to add and [d] to delete");
        System.out.println("write [back] to back and [home] for main tab");
        String command = "";
        Scanner in = new Scanner(System.in);
        while (true) {
            command = in.next();
            switch (command) {
                case "a":
                    System.out.println("Write the information passage and press Enter to add");
                    addNewInformation(in.nextLine());
                    break;
                case "d":
                    deleteInformation();
                    break;
                case "home":
                    main_tab();
                    break;
                case "back":
                    main_tab();
                    break;

            
                default:
                    break;
            }
        }
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
            if (user instanceof Teacher) {
                System.out.println("Add new student : 4");
                Thread.sleep(750);
            }
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
                    if (!(user instanceof Student)) {
                        information_mannager_tab();
                    }
                    break;
                case 3:
                    user.printProfile();
                    break;
                case 4:
                    if (user instanceof Teacher)
                        ((Teacher)user).addStudent();
                    else 
                        System.out.println("Input is invalid!");
                    break;
                                
                default:
                    System.out.println("Input is invalid!");
                    break;
            }
        }
    }
    
}
