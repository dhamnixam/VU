package Person;

import Task.*;

import java.util.Scanner;

import MainPackage.*;

public abstract class Person {
    private String name;
    private String lastName;
    private String fullName;
    private String username;
    private String field;
    protected String ID_number;
    private String email;
    private String phoneNumber;
    private String password = "";
    private int role;
    protected final int student_role = 1;
    protected final int teacher_role = 2;
    protected final int admin_role = 3;


    public Task[] tasks;
    public int taskCount = 0;
    private final int MAX_TASK_NUMBER = 10;


    public void printTasks() throws InterruptedException {
        System.out.println("---YOUR TASKS---");
        for (int i = 0; i < taskCount; i++) {
            System.out.println(Integer.toString(i + 1) + tasks[i].getSubject());
            System.out.println("------------------");
            Thread.sleep(1000);
        }

        Scanner in = new Scanner(System.in);

        if (taskCount == 0) 
            System.out.println("you don't have any task yet. you can press 0 to continue.");
        else
            System.out.println("press 0 or an invalid number to continue and press the number of task to see its details.");

        int command = in.nextInt();
        if (command > taskCount || command == 0) 
            return;
        else 
            printTask_details(command - 1);
    }

    public void printInformation() throws InterruptedException {
        for (int i = 0; i < UserPanel.getInformationAmount(); i++) {
            System.out.println(UserPanel.Notification[i].toString());
            System.out.println("------------------");
            Thread.sleep(1000);
        }
    }

    public void printTask_details(int i) throws InterruptedException {
        System.out.println("------------------------");
        System.out.println("-------------------");
        System.out.println("--------------");
        System.out.println(tasks[i].toString());
        System.out.println("--------------");
        System.out.println("-------------------");
        System.out.println("------------------------");
        Thread.sleep(750);
        printTasks();
    }

    public void printProfile() throws InterruptedException {
        System.out.println("---PROFILE---");
        System.out.println("ID_number: " + this.ID_number);
        System.out.println("name :" + this.name);
        Thread.sleep(1000);
    }

    //constructor
    public Person() {
        tasks = new Task[MAX_TASK_NUMBER];
    } 

    //setters
    public boolean setName(String name) {
        if (Utils.isNameValid(name)) {
            this.name = name;
            if (lastName != null) {
                setFullName();
            }
            return true;
        }
        else
            return false;
    }

    public boolean setLastName(String lastName) {
        if (Utils.isNameValid(lastName)) {
            this.lastName = lastName;
            if (name != null) {
                setFullName();
            }
            return true;
        }
        else
            return false;
    }

    private void setFullName() {
        this.fullName = name + " " + lastName;
    }

    public boolean setUsername(String username) {
        if (Utils.isUsernameValid(username)) {
            this.username = username;
            return true;
        }
        else
            return false;
    }

    public boolean setField(String field) {
        if (Utils.isNameValid(field)) {
            this.field = field;
            return true;
        }
        else
            return false;
    }

    public abstract boolean setID_number(String ID_number);

    public boolean setEmail(String email) {
        if (Utils.isEmailValid(email)) {
            this.email = email;
            return true;
        }
        else
            return false;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if (Utils.isPhoneNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return true;
        }
        else
            return false;
    }

    public boolean setRole(int role) {
        if (role == 1 || role == 2 || role == 3) {
            this.role = role;
            return true;
        }      
        else
            return false;
    }

    public boolean setPassword(String password) {
        if (Utils.isPasswordValid(password)) {
            this.password = password;
            return true;
        }
        else
            return false;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getField() {
        return field;
    }

    public String getID_number() {
        return ID_number;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

}
