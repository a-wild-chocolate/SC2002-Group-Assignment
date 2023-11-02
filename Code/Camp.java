public class Camp {

	private String campName;
	private Date date;
	private Date registrationDate;
	private Faculty userGroup;
	private String location;
	private int totalSlot;
	private int committeeSlot;
	private String description;
	private Staff staffInCharge;
	private Enquiry[] enquiryList;
	private Suggestion[] suggestionList;
	private boolean visibility;

	public String getCampName() {
		return this.campName;
	}

	/**
	 * 
	 * @param campName
	 */
	public void setCampName(String campName) {
		this.campName = campName;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	/**
	 * 
	 * @param registrationDate
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Faculty getUserGroup() {
		return this.userGroup;
	}

	/**
	 * 
	 * @param userGroup
	 */
	public void setUserGroup(Faculty userGroup) {
		this.userGroup = userGroup;
	}

	public String getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @param Location
	 */
	public void setLocation(String Location) {
		this.location = Location;
	}

	public int getTotalSlot() {
		return this.totalSlot;
	}

	/**
	 * 
	 * @param totalSlot
	 */
	public void setTotalSlot(int totalSlot) {
		this.totalSlot = totalSlot;
	}

	public int getCommitteeSlot() {
		return this.committeeSlot;
	}

	/**
	 * 
	 * @param committeeSlot
	 */
	public void setCommitteeSlot(int committeeSlot) {
		this.committeeSlot = committeeSlot;
	}

	public int getDescription() {
		// TODO - implement Camp.getDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Description
	 */
	public void setDescription(int Description) {
		// TODO - implement Camp.setDescription
		throw new UnsupportedOperationException();
	}

	public Staff getStaffInCharge() {
		return this.staffInCharge;
	}

	/**
	 * 
	 * @param staffInCharge
	 */
	public void setStaffInCharge(Staff staffInCharge) {
		this.staffInCharge = staffInCharge;
	}

	public Enquiry[] getEnquiryList() {
		return this.enquiryList;
	}

	/**
	 * 
	 * @param enquiryList
	 */
	public void setEnquiryList(Enquiry[] enquiryList) {
		this.enquiryList = enquiryList;
	}

	public Suggestion[] getSuggestionList() {
		return this.suggestionList;
	}

	/**
	 * 
	 * @param suggestionList
	 */
	public void setSuggestionList(Suggestion[] suggestionList) {
		this.suggestionList = suggestionList;
	}

	public boolean getVisibility() {
		return this.visibility;
	}

	/**
	 * 
	 * @param visibility
	 */
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

}