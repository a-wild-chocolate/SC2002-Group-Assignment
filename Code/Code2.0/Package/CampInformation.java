package Package;

import java.time.LocalDate;
import java.util.ArrayList;

public class CampInformation {

	protected String campName;
	protected LocalDate date;
	protected LocalDate registrationDate;
	protected ArrayList<Faculty> userGroup;
	protected String location;
	protected int totalSlot;
	protected int committeeSlot;
	protected String description;

	public CampInformation(String campName, LocalDate date , LocalDate registrationDate, ArrayList<Faculty> userGroup ,String location,int totalSlot,int committeeSlot, String description)
	{
		this.campName=campName;
		this.date=date;
		this.registrationDate=registrationDate;
		this.userGroup=userGroup;
		this.location=location;
		this.totalSlot=totalSlot;  //totalSlot does not contain committeeSlot. It only calculates the Attendee.
		this.committeeSlot=committeeSlot;
		this.description=description;
	}
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



}