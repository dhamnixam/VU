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

    private void deleteInformation(int index)  {
        if (index >= 0 && index < InformationAmount) {
            Informaion[index] = null;
            for (int i = index; i + 1 < InformationAmount; i++) {
                Informaion[i+1] = Informaion[i];
            }
            InformationAmount--;
            System.out.println("Information deleted successfuly");
        }
        
    }

    private void editInformation() throws InterruptedException {
        user.printInformation();
        System.out.print("Which one do you whant to edit? ");
        int command;
        String passage;
        Scanner in = new Scanner(System.in);
        while (true) {
            command = in.nextInt();
            if (command < InformationAmount && command >= 0) {
                passage = in.nextLine();
                Informaion[command - 1].setPassage(passage);
                System.out.println("Information edited successfuly!");
                break;
            }
        }
    }

    public static int getInformationAmount() {
        return InformationAmount;
    }

    private void task_mannager_tab() throws InterruptedException {
        System.out.println("---TASK MANNAGER TAB---");
        Scanner in = new Scanner(System.in);
        int command;
        while (true) {
            System.out.println("Add new task) 1");
            Thread.sleep(750);
            System.out.println("Remove task) 2");
            Thread.sleep(750);
            System.out.println("Edit) 3");
            Thread.sleep(750);
            System.out.println("Back) 4");
            Thread.sleep(750);
            System.out.println("Home) 5");
            command = in.nextInt();
            switch (command) {
                case 1:
                    addTask_tab();
                    break;
                case 2:
                    removeTask_tab();
                    break;
                case 3:
                    editTask_tab();
                    break;
                case 4:
                user.printTasks();
                    break;
                case 5:
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
                task_mannager_tab();
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
                task_mannager_tab();
                return;
            }
            else if (command.equals("home")) {
                main_tab();
                return;
            }
        }
    }

    private void editTask_tab() throws InterruptedException {
        System.out.println("---Eidt Task Tab---");
        user.printTasks();
        System.out.println("Which one do you want to edit?");
        Scanner in = new Scanner(System.in);
        int command;
        double start_time;
        double end_time;
        String subject;
        while (true) {
            command = in.nextInt();
            if (command < user.taskCount && command >= 0) {
                System.out.print("Set the start time: ");
                start_time = in.nextDouble();
                user.tasks[command - 1].setStart_time(start_time);

                System.out.print("Set the end time: ");
                end_time = in.nextDouble();
                user.tasks[command - 1].setEnd_time(end_time);

                System.out.print("Set the subject of this task: ");
                subject = in.nextLine();
                user.tasks[command - 1].setSubject(subject);
                break;
            }
        }
    }


    private void information_mannager_tab() throws InterruptedException {
        System.out.println("---INFORMATION MANNAGER TAB---");
        System.out.println("Add) 1");
        System.out.println("Delete) 2");
        System.out.println("Edit) 3");
        System.out.println("Back) 4");
        System.out.println("Home) 5");
        int command;
        Scanner in = new Scanner(System.in);
        while (true) {
            command = in.nextInt();
            switch (command) {
                case 1:
                    System.out.print("Write your information passage and press Enter to add:");
                    addNewInformation(in.nextLine());
                    break;
                case 2:
                    deleteInformation();
                    break;
                case 3:
                    editInformation();
                    break;
                case 4:
                    main_tab();
                    break;
                case 5:
                    main_tab();
                    break;

            
                default:
                    break;
            }
        }
    }

    private void show_techers_of_student(Student std) {
        System.out.println("Your Teachers:");
        int i = 0;
        while (true) {
            if (std.getValueAt_teachers(i) == null) {
                break;
            }
            else {
                System.out.println(Integer.toString(i + 1) + ")" + std.getValueAt_teachers(i).getName() + std.getValueAt_teachers(i).getLastName());
            }
        }
    }

    private void show_students_of_teacher(Teacher tchr) {
        System.out.println("Your Students:");
        int i = 0;
        while (true) {
            if (tchr.getValueAt_stuents(i) == null) {
                break;
            }
            else {
                System.out.println(Integer.toString(i + 1) + ")" + tchr.getValueAt_stuents(i).getName() + tchr.getValueAt_stuents(i).getLastName());
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
            System.out.println("Tasks) 1");
            Thread.sleep(750);
            System.out.println("Univercitys Information) 2");
            Thread.sleep(750);
            System.out.println("Profile) 3");
            Thread.sleep(750);
            // if (user instanceof Teacher) {
            //     System.out.println("Add new student) 4");
            //     Thread.sleep(750);
            // }
            System.out.println("Exit) 0");
            Thread.sleep(750);
            System.out.print("Type a number here: ");
            command = in.nextInt();
            switch (command) {
                case 1:
                    user.printTasks();
                    if (!(user instanceof Student)) {
                        task_mannager_tab();
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
                    if (user instanceof Student) {
                        show_techers_of_student((Student)user);
                    }
                    else if (user instanceof Teacher) {
                        show_students_of_teacher((Teacher)user);
                    }
                    break;

                // case 4:
                //     if (user instanceof Teacher)
                //         ((Teacher)user).addStudent();
                //     else if (user instanceof Admin)
                //         ((Admin)user).addStudentForTeacher();
                //     else 
                //         System.out.println("Input is invalid!");
                //     break;
                                
                default:
                    System.out.println("Input is invalid!");
                    break;
            }
        }
    }
    
}
