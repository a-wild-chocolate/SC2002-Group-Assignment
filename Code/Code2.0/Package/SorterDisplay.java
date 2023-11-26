package Package;
import java.time.LocalDate;
import java.util.ArrayList;
/*
import Package.CampList;
import Package.Displayer;
import Package.PerformanceReport;
import Package.RestrictedDisplay;
import Package.SortCampByName;
import Package.Enquiry;
import Package.Sorter;
import Package.Student;
import Package.Report;
*/
import java.util.Scanner;


public class SorterDisplay extends Displayer{
    public static ArrayList<Student> displaySortingMethod(ArrayList<Student> studentList, Report report) {
		
        System.out.println("----- Sorting Methods -----");
		System.out.println();
		System.out.println("1) Sorting by name");
		System.out.println("2) Sorting by score");
        if (report instanceof CampReport){
            System.out.println("3) Sorting by role");
        }
		System.out.println("0) Quit");
		int choice;
        Scanner sc = new Scanner(System.in);
		choice=sc.nextInt();
		switch (choice)
		{
			case 1:
				ArrayList<Student> sortedStudentNameList = Sorter.sortByName(studentList); // Sort the list
                return sortedStudentNameList; // Return the sorted list
                break;
			case 2:
				ArrayList<Student> sortedStudentScoreList = Sorter.sortByScore(studentList); // Sort the list
                return sortedStudentScoreList; // Return the sorted list
				break;
			case 3:
				ArrayList<Student> sortedStudentRoleList = Sorter.sortByRole(studentList); // Sort the list
                return sortedStudentRoleList; // Return the sorted list
				break;
			case 0:
				break;
			default:System.out.println("Invalid Input!!!");
		}
	}

	public static ArrayList<Enquiry> displaySortingEnquiryList(ArrayList<Enquiry> enquiriesList) {
		
        System.out.println("----- Sorting Methods -----");
		System.out.println();
		System.out.println("1) Sorting by sender's name");
		System.out.println("2) Sorting by enquiry ID");
		System.out.println("3) Sorting by status");
		System.out.println("0) Quit");
		int choice;
        Scanner sc = new Scanner(System.in);
		choice=sc.nextInt();
		switch (choice)
		{
			case 1:
				ArrayList<Enquiry> sortedSenderNameList = Sorter.sortByName(enquiriesList); // Sort the list
                return sortedSenderNameList; // Return the sorted list
                break;
			case 2:
				ArrayList<Enquiry> sortedEnquiryIDList = Sorter.sortByID(enquiriesList); // Sort the list
                return sortedEnquiryIDList; // Return the sorted list
				break;
			case 3:
				ArrayList<Enquiry> sortedEnquiryStatusList = Sorter.sortByStatus(enquiriesList); // Sort the list
                return sortedEnquiryStatusList; // Return the sorted list
				break;
			case 0:
				break;
			default:System.out.println("Invalid Input!!!");
		}


	}
}
