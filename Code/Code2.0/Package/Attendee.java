package Package;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Attendee extends Student {

	private ArrayList<Camp> attendeeStatus;
	private ArrayList<Camp> withdrawStatus;
	private ArrayList<Enquiry> enquiryList;
	Scanner sc = new Scanner(System.in);
	Displayer campDisplayer= new RestrictedDisplay();
	public Attendee(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID,name,faculty,password,securityQuestion,secureAnswer);
		attendeeStatus = new ArrayList<Camp>();
		withdrawStatus = new ArrayList<Camp>();
		enquiryList = new ArrayList<Enquiry>();
	}



	public ArrayList<Camp> getAttendeeStatus() {return attendeeStatus;}

	/**
	 * 
	 * @param attendeeStatus
	 */
	public void setAttendeeStatus(ArrayList<Camp> attendeeStatus) {
	this.attendeeStatus=attendeeStatus;
	}

	public ArrayList<Camp> getWithdrawStatus() {
		return withdrawStatus;
	}

	/**
	 * 
	 * @param withdrawStatus
	 */
	public void setWithdrawStatus(ArrayList<Camp> withdrawStatus) {this.withdrawStatus=withdrawStatus;}

	/**
	 * 
	 * @param enquiryList
	 */
	public void setEnquiryList(ArrayList<Enquiry> enquiryList) {this.enquiryList=enquiryList;}

	public ArrayList<Enquiry> getEnquiryList() {
	return enquiryList;
	}


	public void registerAsAttendee() {
		Camp registerCamp=null;
		String campName;
		int choice=0;
		//check this camp is it in the withdrawList
		System.out.println("The list of camp shows below");
		campDisplayer.display(CampList.getCampList(),this);
		do
		{
			System.out.println("Please enter the name of the camp you want to join in, 0 exist");
			campName=sc.nextLine();
			if(campName.equals("0")) return;
			registerCamp=Converter.stringToCamp(campName);
			if(registerCamp==null)
			{
				System.out.println("This camp does not exist.");
				continue;
			}
			if(!(registerCamp.getUserGroup().contains(this.getFaculty()))||this.getWithdrawStatus().contains(registerCamp))
			{
				System.out.println("Sorry, you cannot register this camp");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
			}
			if(this.getCommitteeStatus()!=null&&this.getCommitteeStatus()==registerCamp)
			{
				System.out.println("Sorry, you cannot register this camp since you are the committee member of it ");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
			}

		}while(registerCamp==null);
		this.attendeeStatus.add(registerCamp);
		registerCamp.getStudentList().add(this);

	}

	public void viewCampList() {
		System.out.println("----- Camp List -----");
		System.out.println("Current time: "+ LocalDate.now());
		campDisplayer.display(CampList.getCampList(),this);
		System.out.println();
		System.out.println("1) Filter");
		System.out.println("2) Register Camp as Attendee");
		System.out.println("3) Register Camp as Committee Member");
		System.out.println("0) Quit");
		int choice=0;
		choice=sc.nextInt();
		switch (choice)
		{
			case 1:
				break;
				//TODO Filter
			case 2:
				this.registerAsAttendee();
				break;
			case 3:
				this.registerAsCommittee();
				break;
			case 0:
				break;
			default:System.out.println("Invalid Input!!!");
		}


	}

	public void registerAsCommittee() {
		//check this camp is it in the withdrawList
		Camp registerCamp=null;
		String campName;
		int choice=0;
		//check this camp is it in the withdrawList
		System.out.println("The list of camp shows below");
		campDisplayer.display(CampList.getCampList(),this);
		do
		{
			System.out.println("Please enter the name of the camp you want to join in, 0 exist");
			campName=sc.nextLine();
			if(campName.equals("0")) return;
			registerCamp=Converter.stringToCamp(campName);
			if(registerCamp==null)
			{
				System.out.println("This camp does not exist.");
				continue;
			}
			if(!(registerCamp.getUserGroup().contains(this.getFaculty()))||this.getWithdrawStatus().contains(registerCamp))
			{
				System.out.println("Sorry, you cannot register this camp");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
			}
			if(this.getCommitteeStatus()!=null&&this.getCommitteeStatus()==registerCamp)
			{
				System.out.println("Sorry, you cannot register this camp since you are the committee member of it ");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
			}

		}while(registerCamp==null);
	}


	/**
	 * 
	 * @param camp
	 */
	public void sendEnquiry(Camp camp) {
		// TODO - implement Student.sendEnquiry
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param camp
	 */
	public void editEnquiry(Camp camp) {
		// TODO - implement Student.editEnquiry
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param camp
	 */
	public void deleteEnquiry(Camp camp) {
		// TODO - implement Student.deleteEnquiry
		throw new UnsupportedOperationException();
	}

	public void viewOwnCamp() {
		campDisplayer.display(this.attendeeStatus,this);
	}

	public void withdrawCamp() {
		System.out.println("Please enter the number of Camp you want to withdraw:");
		int i=1;
		int choice =0;
		for (Camp c : this.attendeeStatus)
		{
			System.out.println(i+") "+c.getCampName());
		}
		System.out.println("0) Quit");

		while(true)
		{
			choice=sc.nextInt();
			if(choice==0) break;
			if(choice <0 || choice>this.attendeeStatus.size())
			{
				System.out.println("Invalid Input!!!Please try again");
				continue;
			}
			else {
				Camp removedCamp = this.attendeeStatus.get(choice-1);
				System.out.println("Warning! You are withdrawing "+ removedCamp.getCampName()+ ". \n Please confirm to continue: 1) Yes 2) No");
				int confirm=0;
				confirm=sc.nextInt();
				if(confirm==0) return;
				this.attendeeStatus.remove(removedCamp);
				removedCamp.getStudentList().remove(this);
				this.withdrawStatus.add(removedCamp);
				System.out.println("Successfully delete "+removedCamp.getCampName()+" camp");
			}
		}
	}



	public void start() {
		// TODO - implement Student.start
		throw new UnsupportedOperationException();
	}

}