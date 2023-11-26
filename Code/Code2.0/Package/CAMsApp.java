package Package;
import java.awt.image.PackedColorModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ArrayList<Camp> campList1 = new ArrayList<>();
        Staff staff1 = new Staff(
                "staffID1",
                "Name1",
                AccountStatus.STAFF,  // Assuming you have an enum for account status
                Faculty.EEE,    // Assuming you have an enum for faculty
                "password",
                "SecurityQuestion1",
                "SecureAnswer1",
                campList1
        );
        ArrayList<Camp> campList2 = new ArrayList<>();
        Staff staff2 = new Staff(
                "staffID2",
                "Name2",
                AccountStatus.STAFF,  // Assuming you have an enum for account status
                Faculty.ADM,        // Assuming you have an enum for faculty
                "password",
                "SecurityQuestion2",
                "SecureAnswer2",
                campList2
        );

        ArrayList<Suggestion> suggestionList1 = new ArrayList<>();
        CommitteeMember committeeMember1 = new CommitteeMember(
                "committeeID1",
                "Name1",
                AccountStatus.STUDENT,
                Faculty.CCEB,
                "password",
                "SecurityQuestion1",
                "SecureAnswer1",
                suggestionList1
        );

        // Create the second CommitteeMember object
        ArrayList<Suggestion> suggestionList2 = new ArrayList<>();
        CommitteeMember committeeMember2 = new CommitteeMember(
                "committeeID2",
                "Name2",
                AccountStatus.STUDENT,
                Faculty.ASE,
                "password",
                "SecurityQuestion2",
                "SecureAnswer2",
                suggestionList2
        );

        // Create the third CommitteeMember object
        ArrayList<Suggestion> suggestionList3 = new ArrayList<>();
        CommitteeMember committeeMember3 = new CommitteeMember(
                "committeeID3",
                "Name3",
                AccountStatus.STUDENT,
                Faculty.CEE,
                "password",
                "SecurityQuestion3",
                "SecureAnswer3",
                suggestionList3
        );

        ArrayList<Camp> attendeeStatusList1 = new ArrayList<>();
        ArrayList<Camp> withdrawStatusList1 = new ArrayList<>();
        ArrayList<Enquiry> enquiryList1 = new ArrayList<>();

        // Create the first Attendee object
        Attendee attendee1 = new Attendee(
                "attendeeID1",
                "Name1",
                AccountStatus.STUDENT,
                Faculty.ADM,
                "password",
                "SecurityQuestion1",
                "SecureAnswer1",
                attendeeStatusList1,
                withdrawStatusList1,
                enquiryList1
        );

        // Create ArrayLists for the second Attendee
        ArrayList<Camp> attendeeStatusList2 = new ArrayList<>();
        ArrayList<Camp> withdrawStatusList2 = new ArrayList<>();
        ArrayList<Enquiry> enquiryList2 = new ArrayList<>();

        // Create the second Attendee object
        Attendee attendee2 = new Attendee(
                "attendeeID2",
                "Name2",
                AccountStatus.STUDENT,
                Faculty.ASE,
                "password",
                "SecurityQuestion2",
                "SecureAnswer2",
                attendeeStatusList2,
                withdrawStatusList2,
                enquiryList2
        );

        // Create ArrayLists for the third Attendee
        ArrayList<Camp> attendeeStatusList3 = new ArrayList<>();
        ArrayList<Camp> withdrawStatusList3 = new ArrayList<>();
        ArrayList<Enquiry> enquiryList3 = new ArrayList<>();

        // Create the third Attendee object
        Attendee attendee3 = new Attendee(
                "attendeeID3",
                "Name3",
                AccountStatus.STUDENT,
                Faculty.EEE,
                "password",
                "SecurityQuestion3",
                "SecureAnswer3",
                attendeeStatusList3,
                withdrawStatusList3,
                enquiryList3
        );
        HashMap<String, Attendee> attendeeHashMap = new HashMap<>();
        // Store the first Attendee in the HashMap
        attendeeHashMap.put(attendee1.getUserID(), attendee1);
        // Store the first Attendee in the HashMap
        attendeeHashMap.put(attendee1.getUserID(), attendee2);
        // Store the first Attendee in the HashMap
        attendeeHashMap.put(attendee1.getUserID(), attendee3);
        HashMap<String, Staff> staffHashMap = new HashMap<>();
        staffHashMap.put(staff1.getUserID(), staff1);
        staffHashMap.put(staff2.getUserID(), staff2);
        HashMap<String, CommitteeMember> committeeMemberHashMap = new HashMap<>();
        committeeMemberHashMap.put(committeeMember1.getUserID(), committeeMember1);
        committeeMemberHashMap.put(committeeMember1.getUserID(), committeeMember2);
        committeeMemberHashMap.put(committeeMember1.getUserID(), committeeMember3);


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
