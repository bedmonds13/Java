package EmailApp;

import  java.util.Scanner;
public class EmailApp {
    public String firstName;
    public String lastName;
    String password;
    private String email;
    private String department;
    int mailboxCapacity = 100;
    String alternateEmail;  
    private String company = "BandELabs";
    
  
    public EmailApp(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        setDepartment();
        email = firstName.toLowerCase()+ "." + lastName.toLowerCase()+"@"+department+"."+company+".com";
        this.password = GenerateRandomPassword(10);
        alternateEmail = setAlternateEmail();
    }
    public String setDepartment()
    {
        System.out.println("Enter the department\n1 for Development \n2 for Accounting \n3 for Sales \n0 for none");
        Scanner ln = new Scanner(System.in);
        int depChoice = ln.nextInt();
        switch(depChoice)
        {
            case 0:
            department = "";
            break;
            case 1: 
            department = "Development";
            break;
            case 2: 
            department = "Accounting";
            break;
            case 3: 
            department = "Sales";
            break;

        }
        return "You picked " + department;
    }
    private String GenerateRandomPassword(int length)
    {
        String passwordSet = "ABCDEFGHIJKLMONPQRSTUVWXYZ!=+";
        char[] password  = new char[length];
        for (int i = 0; i < length; i++) {
           int rand =  (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        
        return new String(password);
    }
    //set functions
    public String setPassword()
    {
       System.out.println( "Enter new password " );
       Scanner ln = new Scanner(System.in);
       String newPassword = ln.nextLine();
       this.password = newPassword;
       return newPassword;
    }
    public String setAlternateEmail()
    {
       System.out.println( "Enter alternate email " );
       Scanner ln = new Scanner(System.in);
       String newEmail = ln.next();
       this.alternateEmail = newEmail;
       System.out.println( "Alternate email is " + alternateEmail);
       return newEmail;
    }
    public void setMailboxCapacity( int capacity)
    {
        mailboxCapacity = capacity;
    }

    public void ChangeEmailSettingPrompt()
    {
        System.out.println("Would you like to change any of the following settings? \n1 for YES, 2 for NO");
        Scanner ln = new Scanner(System.in);
        int choice = 0;
        choice = ln.nextInt();
        while(choice != 1 && choice != 2)
        {
            System.out.println("Entered incorrected input \n1 for YES, 2 for NO");
            choice = ln.nextInt();
        }
        if(choice == 1)        
        {
            Boolean exit = false;
            while(!exit)
            {
                System.out.println("Would you like to change any of the following settings? \nEnter 1 for Department \n2 for mail box capacity \n3 for Alternate email \n4 for password \nAything else to exit program");
                int settingsChoice = ln.nextInt();
                switch(settingsChoice)
                {
                    case 1:
                    setDepartment();
                    break;
                    case 2:
                    System.out.println("What is the new capcity?");
                    int capacity = ln.nextInt();
                    setMailboxCapacity(capacity);
                    break;
                    case 3:
                    setAlternateEmail();
                    break;
                    case 4:
                    setPassword();
                    break;             
                    default:
                    exit = true;
                }
           }

        }


    }

    //get methods
    public String getName(){return firstName + " " + lastName;}
    public String getEmail(){return email;}
    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAltEmail(){return alternateEmail; }
    public String getDepartment(){return department;}
    public void DisplayInfo()
    {
        System.out.println("USER NAME: " + getName());
        System.out.println("DEPARTMENT: " + getDepartment());
        System.out.println("EMAIL: " + getEmail());
        System.out.println("ALT EMAIL " + getAltEmail());
        System.out.println("EMAIL CAPACITY: " + getMailboxCapacity());
    }
}
