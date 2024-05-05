package Person;

import java.util.Scanner;

import Task.*;
import question.questionType;

public class Teacher extends Person{
    protected Student[] students;   //students of this teacher

    public Teacher() {
        super();
        setRole(teacher_role);
        students = new Student[10];
    }

    public boolean setID_number(String ID_number) {
        if (Utils.TeacherIsEduNumberValid(ID_number)) { 
            this.ID_number = ID_number;
            return true;
        }
        else
            return false;
    }

    public void addNewHomeWork(String subject, double setStart_time, double end_time) {
        HomeWork homeWork = new HomeWork(subject, setStart_time, end_time);
        if (taskCount < tasks.length) {
            tasks[taskCount] = homeWork;
            taskCount++;
            System.out.println("/Home work added successfuly/");
        }
        else
            System.out.println("your tasks are too many! remove some tasks");
        
        
    }

    public void addNewQuiz(String subject, double setStart_time, double end_time) {
        Quiz quiz = new Quiz(subject, setStart_time, end_time);
        if (taskCount < tasks.length) {
            tasks[taskCount] = quiz;
            taskCount++;
            System.out.println("/quiz added successfuly/");
        }
        else
            System.out.println("your tasks are too many! remove some tasks");
    }

    public void addNewExam(String subject, double setStart_time, double end_time  , int numbers) {
        Exam exam = new Exam(subject, setStart_time, end_time ,numbers);
        if (taskCount < tasks.length) {
            tasks[taskCount] = exam;
            taskCount++;
            System.out.println("/Exam added successfuly/");
        }
        else
            System.out.println("your tasks are too many! remove some tasks");
    }

    public void removeTask() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println(Integer.toString(i+1) + ") " +tasks[i].toString());
        }

        System.out.print("Enter number of task that you want to remove and if you don't want to remove press 0: ");
        Scanner in = new Scanner(System.in);
        int command = 0;
        while (true) {
            command = in.nextInt();
            if (command < 0 || command > taskCount) 
                System.out.println("invalid input! Enter another one");
            else
                break;
        }

        if (command == 0) {
            return;
        }

        tasks[command - 1] = null;
        for (int i = command; i < taskCount; i++) {
            tasks[i - 1] = tasks[i];
        }
        taskCount--;

        System.out.println("Task removed successfuly");
    }

    public void addStudent() {
        Student std = new Student();
        String name;
        String lastName;
        String ID_number;
        int check = 0;
        Scanner in = new Scanner(System.in);
        while (check != 3) {
            switch (check) {
                case 0:
                    System.out.println("Enter students name: ");
                    name = in.next();
                    if (std.setName(name)) 
                        check++;
                    break;
                case 1:
                    System.out.println("Enter students last name: ");
                    lastName = in.next();
                    if (std.setLastName(lastName)) 
                        check++;
                    break;
                case 2:
                    System.out.println("Enter ID number: ");
                    ID_number = in.next();
                    if (std.setID_number(ID_number)) 
                        check++;
                    break;
            
                default:
                    break;
            }
        }
        
        boolean sw = true;
        for (int i = 0; students.length > i ; i++) {
            if (students[i].getID_number().equals(std.getID_number()) && students[i].getFullName().equals(std.getFullName())) {
                System.out.println("Teacher have this student already!");
                sw = false;
                break;
            }
            if (students[i] == null) {
                students[i] = std;
                System.out.println("Student added successfuly!");
                sw = false;
                break;
            }
        }
        if (sw) {
            System.out.println("This teacher cannot have another student.");
        }
    }
}
