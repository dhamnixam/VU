package Person;

import Task.*;

public abstract class Person {
    private String name;
    private String lastName;
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

    public void addNewHomeWork(String subject, double setStart_time, double end_time) {
        HomeWork homeWork = new HomeWork(subject, setStart_time, end_time);
        tasks[taskCount] = homeWork;
        taskCount++;
    }

    public void addNewQuiz(String subject, double setStart_time, double end_time) {
        Quiz quiz = new Quiz(subject, setStart_time, end_time);
        tasks[taskCount] = quiz;
        taskCount++;
    }

    public void addNewExam(String subject, double setStart_time, double end_time) {
        Exam exam = new Exam(subject, setStart_time, end_time);
        tasks[taskCount] = exam;
        taskCount++;
    }

    public void printTasks() throws InterruptedException {
        for (int i = 0; i < taskCount; i++) {
            System.out.println(tasks[i].toString());
            System.out.println("------------------");
            Thread.sleep(1000);
        }
    }

    public void printInformation() throws InterruptedException {
        for (int i = 0; i < UserPanel.getInformationAmount(); i++) {
            System.out.println(UserPanel.information[i].toString());
            System.out.println("------------------");
            Thread.sleep(1000);
        }
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
            return true;
        }
        else
            return false;
    }

    public boolean setLastName(String lastName) {
        if (Utils.isNameValid(lastName)) {
            this.lastName = lastName;
            return true;
        }
        else
            return false;
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

}
