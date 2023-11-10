import java.util.ArrayList;
import java.util.List;

public class Camp {

	private String campName;
	private Date date;
	private Date registrationDate;
	private Faculty userGroup;
	private String location;
	private int totalSlot;
	private int committeeSlot;
	private int studentSlot;
	private String description;
	private Staff staffInCharge;
	private List<Enquiry> enquiryList;
	private List<Suggestion> suggestionList;
	private List<String> visibility;
	private List<Student> studentList;
	private List<CommitteeMember> committeeMemberList;
	private int currentStudents;
	private int currentCommitteeMembers;
	private List<Student> bannedList;

	public Camp(
		String campName, String location, String description,
		Date date, Date registrationDate,
		Faculty userGroup,
		int committeeSlot, int studentSlot,
		Staff staffInCharge,
		List<String> visiblity
	){
		this.currentStudents = 0;
		this.currentCommitteeMembers = 0;
		this.campName = campName;
		this.location = location;
		this.description = description;
		this.userGroup = userGroup;
		this.committeeSlot = committeeSlot;
		this.studentSlot = studentSlot;
		this.totalSlot = committeeSlot + studentSlot;
		this.date = date;
		this.registrationDate = registrationDate;
		this.staffInCharge = staffInCharge;
        this.studentList = new ArrayList<>();
        this.committeeMemberList = new ArrayList<>();
		this.enquiryList = new ArrayList<>();
		this.suggestionList = new ArrayList<>();
		this.bannedList = new ArrayList<>();
		for (String str : visibility){
			this.visibility.add(str);
		}
	}
	public String getCampName() {
		return this.campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Faculty getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(Faculty userGroup) {
		this.userGroup = userGroup;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String Location) {
		this.location = Location;
	}

	public int getTotalSlot() {
		return this.totalSlot;
	}

	public int getStudentSlot(){
		return this.studentSlot;
	}

	public void setStudentSlot(int studentSlot) {
		this.studentSlot = studentSlot;
		this.totalSlot = this.studentSlot + this.committeeSlot;
	}

	public int getCommitteeSlot() {
		return this.committeeSlot;
	}

	public void setCommitteeSlot(int committeeSlot) {
		this.committeeSlot = committeeSlot;
		this.totalSlot = this.studentSlot + this.committeeSlot;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Staff getStaffInCharge() {
		return this.staffInCharge;
	}

	public void setStaffInCharge(Staff staffInCharge) {
		this.staffInCharge = staffInCharge;
	}

	public void addSuggestion(Suggestion suggestion){
		this.suggestionList.add(suggestion);
	}

	public void deleteSuggestion(Suggestion suggestion){
		this.suggestionList.remove(suggestion);
	}

	public void addEnquiry(Enquiry enquiry){
		this.enquiryList.add(enquiry);
	}

	public void deleteEnquiry(Enquiry enquiry){
		this.enquiryList.remove(enquiry);
	}

	public void addStudent(Student student){
		if(!bannedList.contains(student)){
			if(this.currentStudents<this.studentSlot){
				this.studentList.add(student);
				this.currentStudents++;
			}
			else{
				System.out.println("This camp is already full\n");
			}
		}
		else{
			System.out.println("This student is banned");
		}

	}

	public void deleteStudent(Student student){
		if(this.currentStudents == 0){
			System.out.println("No students to delete\n");
		}
		else{
			if(!studentList.contains(student)){
				System.out.println("This student has not applied to this camp\n");
			}
			else{
				this.studentList.remove(student);
				this.bannedList.add(student);
				this.currentStudents--;
			}
		}
	}

	public List<Student> getStudents(){
		return this.studentList;
	}

	public void addCommitteeMember(CommitteeMember committeeMember){
		if(this.currentCommitteeMembers<this.committeeSlot){
			this.committeeMemberList.add(committeeMember);
			this.currentCommitteeMembers++;
		}
		else{
			System.out.println("Committee for this camps is full\n");
		}
	}

	public void getAllInformation(){
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



	public List<String> getVisibility() {
		return this.visibility;
	}

	public void addVisibility(String visibility){
		if(!this.visibility.contains(visibility)){
			this.visibility.add(visibility);
		}
		else{
			System.out.println("Camp already has this visibility\n");
		}
	}

	public void deleteVisibility(String visibility){
		if(this.visibility.contains(visibility)){
			this.visibility.remove(visibility);
		}
		else{
			System.out.println("Camp already does not contain this visibility setting\n")
		}
	}



}
