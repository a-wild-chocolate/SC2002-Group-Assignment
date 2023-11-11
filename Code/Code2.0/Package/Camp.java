package Package;

import java.time.LocalDate;

public class Camp extends CampInformation {

	private Staff staffInCharge;
	private ArrayList<Enquiry> enquiryList;
	private ArrayList<Suggestion> suggestionList;
	private ArrayList<Faculty> visibility;
	private ArrayList<Student> studentList;
	private int remainSlot;

	public Camp(String campName, LocalDate date,LocalDate registrationDate , ArrayList<Faculty> userGroup,Staff staff,ArrayList<Faculty> visibility)
	{
		super()
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

	public ArrayList<Enquiry> getEnquiryList() {

	}

	public ArrayList<Suggestion> getSuggestionList() {

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

	/**
	 * 
	 * @param enquiryList
	 */
	public void setEnquiryList(ArrayList<Enquiry> enquiryList) {
		// TODO - implement Camp.setEnquiryList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param suggestionList
	 */
	public void setSuggestionList(ArrayList<Suggestion> suggestionList) {
		// TODO - implement Camp.setSuggestionList
		throw new UnsupportedOperationException();
	}

	public ArrayList<Student> getStudentList() {
		return this.studentList;
	}

	/**
	 * 
	 * @param studentList
	 */
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public int getRemainSlot() {
		return this.remainSlot;
	}

	/**
	 * 
	 * @param remainSlot
	 */
	public void setRemainSlot(int remainSlot) {
		this.remainSlot = remainSlot;
	}

}