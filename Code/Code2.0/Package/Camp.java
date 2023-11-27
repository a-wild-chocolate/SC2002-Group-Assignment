package Package;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Camp extends CampInformation {

	private Staff staffInCharge;
	private ArrayList<Enquiry> enquiryList;
	private ArrayList<Suggestion> suggestionList;
	private Boolean visibility; //on/off visible to students. Different from user group.
	private ArrayList<Student> studentList;
	private ArrayList<Student> committeeMemberList;
	private int remainSlot;
	private final String FILE_NAME = "campList";


	public ArrayList<Student> getCommitteeMemberList() {

		return committeeMemberList;
	}

	public void setCommitteeMemberList(ArrayList<Student> committeeMemberList) {
		this.committeeMemberList = committeeMemberList;
	}



	public Camp(String campName, LocalDate date , LocalDate registrationDate, ArrayList<Faculty> userGroup , String location, int totalSlot, int committeeSlot, String description,Staff staffInCharge, Boolean visibility)
	{
		super(campName,date,registrationDate,userGroup,location,totalSlot,committeeSlot,description);
		this.staffInCharge=staffInCharge;
		this.visibility=visibility;
		this.enquiryList=new ArrayList<>();
		this.suggestionList=new ArrayList<Suggestion>();
		this.studentList=new ArrayList<>();
		this.remainSlot=totalSlot-this.studentList.size();
		this.committeeMemberList=new ArrayList<Student>();
		writeToCampListCSV();
	}

	public Camp(String campName, LocalDate date , LocalDate registrationDate, ArrayList<Faculty> userGroup , String location, int totalSlot, int committeeSlot, String description,Staff staffInCharge,ArrayList<Enquiry> enquiryList,ArrayList<Suggestion> suggestionList, Boolean visibility,ArrayList<Student> studentList, ArrayList<Student> committeeMemberList)
	{
		super(campName,date,registrationDate,userGroup,location,totalSlot,committeeSlot,description);
		this.staffInCharge=staffInCharge;
		this.visibility=visibility;
		this.enquiryList=enquiryList;
		this.suggestionList=suggestionList;
		this.studentList=studentList;
		this.remainSlot=totalSlot-this.studentList.size();
		this.committeeMemberList= committeeMemberList;

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
		writeToCampListCSV();
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
		writeToCampListCSV();
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

	public void writeToCampListCSV()
	{
		String header = "campName,date,registrationDate,userGroup,location,total Slots,committeeSlot,description,Staff In Charge,Visibility,remain slots\n";
		CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME,header);
		//String csvData = String.join(",", this.enquiryId, this.sender, this.camp, this.status, this.dealer.getName(), this.content);
		String csvData=toCamplistString();
		try {
			csvModifier.checkCreateOrUpdate(this.getCampName(), csvData);
		} catch (IOException e) {
			System.out.println("An I/O error occurred while creating the new account.");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("The cryptographic algorithm is not available in the current environment.");
			e.printStackTrace();
		}
	}

	public boolean deleteCamp(String onlyID) throws IOException {
		Path filePath = Paths.get(FILE_NAME);
		if (Files.notExists(filePath)) {
			// If the file does not exist, there is no account to delete
			return false;
		}

		// Read all lines except the one with the matching userID
		List<String> outLines = Files.lines(filePath)
				.filter(line -> !line.startsWith(onlyID + ","))
				.collect(Collectors.toList());

		// Check if the account was found and removed
		boolean accountRemoved = outLines.size() < Files.readAllLines(filePath).size();

		if (accountRemoved) {
			// Write the remaining lines back to the CSV file
			Files.write(filePath, outLines);
		}
		return accountRemoved;
	}

	private String toCamplistString() {
		String campNameStr = (this.campName == null) ? "" : this.campName;
		String dateStr = this.date.toString();
		String registrationDateStr = this.registrationDate.toString();
		String userGroupStr = userGroup.stream()
				.map(Faculty::toString)
				.collect(Collectors.joining("+"));
		String locationStr = (this.getLocation() == null) ? "" : this.getLocation();
		String totalSlotsStr = Integer.toString(this.totalSlot);
		String committeeSlotStr = Integer.toString(this.committeeSlot);
		String descriptionStr = this.description != null ? this.description : "";
		String staffInChargeStr = this.staffInCharge != null ? this.staffInCharge.getUserID(): ""; // Assuming Staff has a proper toString method.
		String visibilityStr = this.visibility ? "Visible" : "Not Visible";
		String remainSlotsStr = Integer.toString(this.remainSlot);

		return String.join(", ", campNameStr,
				dateStr,
				registrationDateStr,
				userGroupStr,
				locationStr,
				totalSlotsStr,
				committeeSlotStr,
				descriptionStr,
				staffInChargeStr,
				visibilityStr,
				remainSlotsStr);
	}

	public void printAllInformation() {
		System.out.println(
				"Camp name: " + this.campName + "\n" +
						"Camp Date: " + this.date + "\n" +
						"Camp Registration closure date " + this.registrationDate + "\n" +
						"Camp open to faculties: " + this.userGroup + "\n" +
						"Camp Location: " + this.location + "\n" +
						"Camp total Slots: " + this.totalSlot + "\n" +
						"Camp committeeMember slots: " + this.committeeSlot + "\n" +
						"Camp description: " + this.description + "\n" +
						"Camp staff in charge: " + this.staffInCharge + "\n" +
						"Camp current number of students: " + this.studentList.size() + "\n" +
						"Camp current number of committee members: " + this.committeeMemberList.size() + "\n"
		);
	}
}