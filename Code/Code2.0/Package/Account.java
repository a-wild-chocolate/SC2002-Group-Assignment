package Package;

public abstract class Account extends AccountInformation {

	private Searcher searcher;
	private Displayer campDisplayer;
	protected Scanner sc=new Scanner(System.in);

	public abstract void ViewCampList();

	public Account() {
		// TODO - implement Account.Account
		throw new UnsupportedOperationException();
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