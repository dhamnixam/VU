import java.util.Scanner;

public class LoginPage {

    private Person user;
    

    public void loginMessages() throws InterruptedException {
        boolean sw = false;
        String errorMessage = "your input is invalid!";
        String ID_number;
        String password;
        Scanner in = new Scanner(System.in);

        System.out.println("---LOGIN PAGE---");
        Thread.sleep(1000);
        
        do {
            System.out.print("Enter your ID number: ");
            ID_number = in.next();
            sw = true;
            if (Utils.stuIsEduNumberValid(ID_number)) 
                user = new Student();
            else if (Utils.TeacherIsEduNumberValid(ID_number)) 
                user = new Teacher();
            else if (Utils.adminIsEduNumberValid(ID_number)) 
                user = new Admin();
            else {
                System.out.println(errorMessage);
                sw = false;
            }
            
        } while (sw == false);
        sw = false;


        do {
            System.out.print("Enter your Password: ");
            password = in.next();
            if (Utils.isPasswordValid(password)) 
                sw = true;
            else
                System.out.println(errorMessage);
        } while (sw == false);

        boolean show_message_sw = false;
        for (int i = 0; SighUp.persons[i] != null; i++) {
            if (ID_number.equals(SighUp.persons[i].getID_number()) && password.equals(SighUp.persons[i].getPassword())) {

                System.out.println("--------------------------");
                System.out.println("Wellcom " + SighUp.persons[i].getName() + " " + SighUp.persons[i].getLastName() + "!!!");
                System.out.println("--------------------------");
                user = SighUp.persons[i];

                Thread.sleep(1000);
                show_message_sw = true;
                break;
            }
        }
        if (show_message_sw == false) {
            System.out.println("Ther is no account with this information.you have to signup first...");
        }  
        else {
            transferToUserPanel(user);
        }
    }

    private void transferToUserPanel(Person person) throws InterruptedException {
        UserPanel userPanel = new UserPanel(person);
        userPanel.showPanelStatus();
    }
}
