import EmailApp.EmailApp;

public class FirstJavaProgram
{
    public static void main(String []args){
        EmailApp newEmail = new EmailApp("Bruce","Oneal");
        System.out.println("My name  is " + newEmail.getName());
        System.out.println("My email is " + newEmail.getEmail());
        System.out.println("My current email capacity is " + newEmail.getMailboxCapacity());
        
        //Ask user if they  would like to change any email settings
        newEmail.ChangeEmailSettingPrompt();

        newEmail.DisplayInfo();
        
    }
}