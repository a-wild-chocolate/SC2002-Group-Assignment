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
		Camp registerCamp;
		String campName;
		int choice=0;
		//check whether this camp is in the withdrawList
		System.out.println("The list of camp shows below");
		campDisplayer.display(CampList.getCampList(),this);
		do
		{
			System.out.println("Please enter the name of the camp you want to join in, 0 exit");
			campName=sc.nextLine();
			if(campName.equals("0")) return;
			registerCamp=Converter.stringToCamp(campName);
			//check whether this camp exist
			if(registerCamp==null||!registerCamp.getVisibility())
			{
				System.out.println("This camp does not exist.");
				continue;
			}
			//check whether this camp is due
			if(registerCamp.getRegistrationDate().compareTo(LocalDate.now())<0)
			{
				System.out.println("Sorry, this camp is due. You cannot register this camp");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				choice=sc.nextInt();
				if(choice==0) return;
				registerCamp=null;
				continue;
			}
			//check whether this camp is full
			if(registerCamp.getTotalSlot()==registerCamp.getStudentList().size())
			{
				System.out.println("Sorry,this camp has no spare slot.");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
				registerCamp=null;
				continue;
			}

			//check this camp is it in the withdrawList
			if(!(registerCamp.getUserGroup().contains(this.getFaculty()))||this.getWithdrawStatus().contains(registerCamp))
			{
				System.out.println("Sorry, you cannot register this camp");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
				registerCamp=null;
				continue;
			}
			//check whether this student is the committee member of it
			if(this.getCommitteeStatus()!=null&&this.getCommitteeStatus()==registerCamp)
			{
				System.out.println("Sorry, you cannot register this camp since you are the committee member of it ");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
				registerCamp=null;
			}

		}while(registerCamp==null);
		this.attendeeStatus.add(registerCamp);
		registerCamp.getStudentList().add(this);

	}

	public void registerAsCommittee() {
		//check whether this student is already a committee member.
		if(this.getCommitteeStatus()!=null)
		{
			System.out.println("Sorry, you are the committee member of "+this.getCommitteeStatus().getCampName()+". You can only be committee member in one committee.");
			return;
		}
		Camp registerCamp;
		String campName;
		int choice=0;
		//display the camp list and details
		System.out.println("The list of camp shows below");
		campDisplayer.display(CampList.getCampList(),this);
		do
		{
			//let student enter the name of his choice
			System.out.println("Please enter the name of the camp you want to join in, 0 exist");
			campName=sc.nextLine();
			//check quit choice
			if(campName.equals("0")) return;
			//string transfers to camp object
			registerCamp=Converter.stringToCamp(campName);
			//check whether this camp does not exist or not visible
			if(registerCamp==null||!registerCamp.getVisibility())
			{
				System.out.println("This camp does not exist.");
				registerCamp=null;
				continue;
			}
			//check whether this camp is due
			if(registerCamp.getRegistrationDate().compareTo(LocalDate.now())<0)
			{
				System.out.println("Sorry, this camp is due. You cannot register this camp");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				choice=sc.nextInt();
				if(choice==0) return;
				registerCamp=null;
				continue;
			}
			//check whether this camp is full
			if(registerCamp.getCommitteeSlot()== registerCamp.getCommitteeMemberList().size())
			{
				System.out.println("Sorry, this camp's committee member is full.\n You cannot register as this camp's committee member.");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
				registerCamp=null;
				continue;
			}
			//check whether this camp is in the withdrawal list or student's faculty is not in the list
			if(!(registerCamp.getUserGroup().contains(this.getFaculty()))||this.getWithdrawStatus().contains(registerCamp))
			{
				System.out.println("Sorry, you cannot register this camp");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
				registerCamp=null;
				continue;
			}
			//check whether this student register this camp as attendee
			if(this.getAttendeeStatus()!=null&&this.getAttendeeStatus().contains(registerCamp))
			{
				System.out.println("Sorry, you cannot register this camp since you are the attendee of it.\n  ");
				System.out.println("0) Quit");
				System.out.println("1) Register other camp");
				if(choice==0) return;
				registerCamp=null;

			}

		}while(registerCamp==null);

		// update student's committee member status;
		this.setCommitteeStatus(registerCamp);
		// update camp's committee member status
		registerCamp.getCommitteeMemberList().add(this);
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
		int choice;
		choice=sc.nextInt();
		switch (choice)
		{
			case 1:
				Displayer campDisplayer= new RestrictedDisplay();
				campDisplayer.display(SearchApp.searchApp(CampList.getCampList()),this);
				break;
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
		System.out.println("----- Camps Attended as Attendee-----");
		campDisplayer.display(this.attendeeStatus,this);
		if(this.getCommitteeStatus()!=null)
		{
			System.out.println("----- Camps Attended as Committee Member -----");
			ArrayList committeeCampList = new ArrayList<Camp>();
			committeeCampList.add(this.getCommitteeStatus());
			campDisplayer.display(committeeCampList,this);
		}
		//TODO - implement filter

	}

	public void withdrawCamp() {
		System.out.println("Please enter the number of Camp you want to withdraw:");
		int i=1;
		int choice;
		for (Camp c : this.attendeeStatus)
		{
			System.out.println(i+") "+c.getCampName());
		}
		System.out.println("0) Quit");

		while(true)
		{
			choice=sc.nextInt();
			if(choice==0) break;
			//check input error
			if(choice <0 || choice>this.attendeeStatus.size())
			{
				System.out.println("Invalid Input!!!Please try again");
			}

			else {
				//get removed camp
				Camp removedCamp = this.attendeeStatus.get(choice-1);
				//check current time and camp time
				if(removedCamp.getDate().compareTo(LocalDate.now())<0)
				{
					System.out.println("Sorry, this camp is over time. You cannot withdraw it.");
					return;
				}
				// remind user about dangerous operation
				System.out.println("Warning! You are withdrawing "+ removedCamp.getCampName()+ ". \n Please confirm to continue: 1) Yes 2) No");
				int confirm;
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