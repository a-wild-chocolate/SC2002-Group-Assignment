public class Student extends Account {

	private Camp committeeStatus;
	private Camp[] attendeeStatus;
	private Camp[] withdrawStatus;
	private Enquiry[] enquiryList;

	public void getCommitteeStatus() {
		// TODO - implement Student.getCommitteeStatus
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param committeeStatus
	 */
	public void setCommitteeStatus(int committeeStatus) {
		// TODO - implement Student.setCommitteeStatus
		throw new UnsupportedOperationException();
	}

	public Camp[] getAttendeeStatus() {
		return this.attendeeStatus;
	}

	/**
	 * 
	 * @param attendeeStatus
	 */
	public void setAttendeeStatus(Camp[] attendeeStatus) {
		this.attendeeStatus = attendeeStatus;
	}

	public Camp[] getWithdrawStatus() {
		return this.withdrawStatus;
	}

	/**
	 * 
	 * @param withdrawStatus
	 */
	public void setWithdrawStatus(Camp[] withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	/**
	 * 
	 * @param enquiryList
	 */
	public void setEnquiryList(Enquiry[] enquiryList) {
		this.enquiryList = enquiryList;
	}

	public Enquiry[] getEnquiryList() {
		return this.enquiryList;
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

	/**
	 * 
	 * @param camp
	 */
	public void registerAsCommittee(Camp camp) {
		// TODO - implement Student.registerAsCommittee
		throw new UnsupportedOperationException();
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
		// TODO - implement Student.viewOwnCamp
		throw new UnsupportedOperationException();
	}

	public void withdrawCamp() {
		// TODO - implement Student.withdrawCamp
		throw new UnsupportedOperationException();
	}

}