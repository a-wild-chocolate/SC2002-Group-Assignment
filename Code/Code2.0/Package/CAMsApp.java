package Package;

import java.util.Scanner;

public class CAMsApp {
    public static void main(String[] args)
    {
        //TODO: LoadObjects
        LoginAccount loginAccountS;
        String id;
        String password;
        int choice;
        Account user;
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println();
            System.out.println("===Camp Application and Management System===");
            System.out.println("1) Login");
            System.out.println("0) Quit");
            choice=sc.nextInt();
            if(choice==0) return;

            System.out.println("---------Login---------");
            System.out.println("Enter your ID:");
            id=sc.nextLine();
            System.out.println("Enter your password:");
            password=sc.nextLine();
            loginAccountS=new LoginAccount(id,password);
            user=loginAccountS.loginAccount(); //TODO: update loginAccount
            if(user.getAccountStatus()==AccountStatus.STAFF)
            {
                ((Staff) user).start();
            }
            else if(user.getAccountStatus()==AccountStatus.STUDENT)
            {

                while (true)
                {
                    System.out.println("Do you want to use attendee account or committee account today?");
                    System.out.println("1) Attendee account");
                    System.out.println("2) Committee account");
                    System.out.println("0) Quit");
                    choice=sc.nextInt();
                    if(choice==0) break;
                    else if(choice==1)
                    {
                        (Attendee)user=createObject; // TODO:get attendee
                        ((Attendee)user).start();//jump to attendee start
                    }
                    else if(choice==2)
                    {
                        (CommitteeMember)user = createObject; //TODO:get committeeMember
                        ((CommitteeMember)user).start();//jump to committee member start
                    }

                    System.out.println();
                }

            }
        }

    }
}
