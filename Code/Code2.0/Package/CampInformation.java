package Package;

public class CampInformation {

	private String campName;
	private Date date;
	private Date registrationDate;
	private ArrayList<Faculty> userGroup;
	private String location;
	private int totalSlot;
	private int committeeSlot;
	private String description;

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

	public ArrayList<Faculty> getUserGroup() {
		return this.userGroup;
	}

	/**
	 * 
	 * @param userGroup
	 */
	public void setUserGroup(ArrayList<Faculty> userGroup) {
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
		// TODO - implement CampInformation.getDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Description
	 */
	public void setDescription(int Description) {
		// TODO - implement CampInformation.setDescription
		throw new UnsupportedOperationException();
	}

	public void printAllInformation() {
		// TODO - implement CampInformation.printAllInformation
		throw new UnsupportedOperationException();
	}

}