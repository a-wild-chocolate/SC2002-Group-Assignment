package Package;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchApp {

    public static ArrayList searchApp(ArrayList<Camp> camp)
    {
        Scanner sc=new Scanner(System.in);
        int filterChoice=0;
        System.out.println("Please choose the parameter you want to filte:");
        System.out.println("1) Name;");
        System.out.println("2) Date;");
        System.out.println("3) Location;");
        System.out.println("4) RegistrationDate;");
        System.out.println("5) Total Slot Number;");
        System.out.println("6) Committee Slot Number;");
        System.out.println("7) Remain Slot Number;");
        System.out.println("8) User Group (faculty);");
        System.out.println("0) Quit;");
        filterChoice=sc.nextInt();
        while(true)
        {
            switch (filterChoice)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Input!!!");

            }
        }
    }
}
