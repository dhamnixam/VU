package MainPackage;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserPanel.addNewInformation("A22 class is out of use today at 7 to 10 AM");
        
        SighUp signUp = new SighUp();
        signUp.signUpMessages();

        LoginPage loginPage = new LoginPage();
        loginPage.loginMessages();
    }
}
