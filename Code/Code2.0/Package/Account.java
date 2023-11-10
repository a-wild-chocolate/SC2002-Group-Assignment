package Package;
import java.util.ArrayList;
import java.util.List;

public abstract class Account extends AccountInformation {

	protected Searcher searcher;
	protected Displayer campDisplayer = new Displayer();


	public abstract void ViewCampList();

	public Account(String userID, String name,  String faculty) {
		// TODO - implement Account.Account
		super(userID,name,faculty);
	}

	public void printInformation() {
		// TODO - implement Account.printInformation
		System.out.println(
				"Camp name: "+this.campName+"\n"+
						"Camp Date: "+this.date+"\n"+
						"Camp Registration closure date "+this.registrationDate+"\n"+
						"Camp open to faculties: "+this.userGroup+"\n"+
						"Camp Location: "+this.location+"\n"+
						"Camp total Slots: "+this.totalSlot+"\n"+
						"Camp attendee slots: "+this.studentSlot+"\n"+
						"Camp committeeMember slots: "+this.committeeSlot+"\n"+
						"Camp description: "+this.description+"\n"+
						"Camp staff in charge: "+this.staffInCharge+"\n"+
						"Camp current number of students: "+this.currentStudents+"\n"+
						"Camp current number of committee members: "+this.currentCommitteeMembers
		);
	}

}