package Package;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camp extends CampInformation {

	private Staff staffInCharge;
	private ArrayList<Enquiry> enquiryList;
	private ArrayList<Suggestion> suggestionList;
	private Boolean visibility; //on/off visible to students. Different from user group.
	private ArrayList<Student> studentList;
	private int remainSlot;

	public ArrayList<Student> getCommitteeMemberList() {
		return committeeMemberList;
	}

	public void setCommitteeMemberList(ArrayList<Student> committeeMemberList) {
		this.committeeMemberList = committeeMemberList;
	}

	private ArrayList<Student> committeeMemberList;

	public Camp(String campName, LocalDate date , LocalDate registrationDate, ArrayList<Faculty> userGroup , String location, int totalSlot, int committeeSlot, String description,Staff staffInCharge, Boolean visibility)
	{
		super(campName,date,registrationDate,userGroup,location,totalSlot,committeeSlot,description);
		this.staffInCharge=staffInCharge;
		this.visibility=visibility;
		this.enquiryList=new ArrayList<>();
		this.suggestionList=new ArrayList<>();
		this.studentList=new ArrayList<>();
		this.remainSlot=totalSlot-this.studentList.size();
		this.committeeMemberList=new ArrayList<>();
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
	return this.enquiryList;
	}

	public ArrayList<Suggestion> getSuggestionList() {
		return this.suggestionList;
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
		this.enquiryList=enquiryList;
	}

	/**
	 * 
	 * @param suggestionList
	 */
	public void setSuggestionList(ArrayList<Suggestion> suggestionList) {
		this.suggestionList=suggestionList;
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



	public void printAllInformation() {
		System.out.println(
				"Camp name: "+this.campName+"\n"+
						"Camp Date: "+this.date+"\n"+
						"Camp Registration closure date "+this.registrationDate+"\n"+
						"Camp open to faculties: "+this.userGroup+"\n"+
						"Camp Location: "+this.location+"\n"+
						"Camp total Slots: "+this.totalSlot+"\n"+
						"Camp committeeMember slots: "+this.committeeSlot+"\n"+
						"Camp description: "+this.description+"\n"+
						"Camp staff in charge: "+this.staffInCharge+"\n"+
						"Camp current number of students: "+this.studentList.size()+"\n"+
						"Camp current number of committee members: "+this.committeeMemberList.size()+"\n"
		);
	}


}