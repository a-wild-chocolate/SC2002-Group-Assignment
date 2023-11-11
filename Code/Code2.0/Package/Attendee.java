package Package;

import java.util.ArrayList;
import java.util.Scanner;

public class Attendee extends Student {

	private ArrayList<Camp> attendeeStatus;
	private ArrayList<Camp> withdrawStatus;
	private ArrayList<Enquiry> enquiryList;
	Scanner sc = new Scanner(System.in);

	public Attendee(String userID, String name, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID,name,faculty,password,securityQuestion,secureAnswer);
		attendeeStatus = new ArrayList<Camp>();
		withdrawStatus = new ArrayList<Camp>();
		enquiryList = new ArrayList<Enquiry>();
	}



	public ArrayList<Camp> getAttendeeStatus() {

	}

	/**
	 * 
	 * @param attendeeStatus
	 */
	public void setAttendeeStatus(ArrayList<Camp> attendeeStatus) {

	}

	public ArrayList<Camp> getWithdrawStatus() {

	}

	/**
	 * 
	 * @param withdrawStatus
	 */
	public void setWithdrawStatus(ArrayList<Camp> withdrawStatus) {

	}

	/**
	 * 
	 * @param enquiryList
	 */
	public void setEnquiryList(ArrayList<Enquiry> enquiryList) {

	}

	public ArrayList<Enquiry> getEnquiryList() {

	}

	/**
	 * 
	 * @param camp
	 */
	public void registerAsAttendee(Camp camp) {
		// TODO - implement Student.registerAsAttendee
		throw new UnsupportedOperationException();
	}

	public void viewCampList() {
		// TODO - implement Student.viewCampList
		throw new UnsupportedOperationException();
	}

	public void registerAsCommittee() {
		//check this camp is it in the withdrawList

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
		campDisplayer= new RestrictedDisplay();
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