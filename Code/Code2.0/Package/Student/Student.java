package Package.Student;

import Package.Account.*;
import Package.CSVManager.CSVReadWriter;
import Package.Camp.*;
import Package.Enum.AccountStatus;
import Package.Enum.Faculty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Student extends Account {

	private int point;
	private Camp committeeStatus;
	private ArrayList<LocalDate> daysOccupied;
	private final String FILE_NAME = "studentList";

	public Student(String userID, String name, AccountStatus accountStatus, Faculty faculty, String password, String securityQuestion, String secureAnswer) {
		super(userID, name,accountStatus, faculty, password, securityQuestion, secureAnswer);
		this.point = 0;
		this.daysOccupied=new ArrayList<LocalDate>();
		committeeStatus = null;
	}

	public Student(String userID, String name,AccountStatus accountStatus, Faculty faculty, String password, String securityQuestion, String secureAnswer, int point) {
		super(userID, name,accountStatus, faculty, password, securityQuestion, secureAnswer);
		this.point = point;
		this.daysOccupied=new ArrayList<LocalDate>();
		committeeStatus = null;
	}

	public int getPoint() {
		return this.point;
	}

	/**
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
		writeToStudentCSV();
	}

	public Camp getCommitteeStatus() {
		return this.committeeStatus;
	}

	/**
	 * @param committeeStatus
	 */
	public void setCommitteeStatus(Camp committeeStatus) {
		this.committeeStatus = committeeStatus;
		writeToStudentCSV();
	}


	public ArrayList<LocalDate> getDaysOccupied() {
		return this.daysOccupied;
	}


	public void setDaysOccupied(ArrayList<LocalDate> daysOccupied) {
		this.daysOccupied = daysOccupied;
		writeToStudentCSV();
	}

	public void viewProfile()
	{
		System.out.println("Name: "+ this.getName());
		System.out.println("UserID: "+this.getUserID());
		System.out.println("Faculty: "+this.getFaculty().toString());
		System.out.println("Email: "+this.getUserID()+"@e.ntu.edu.sg");
		if(this.getCommitteeStatus()==null)
		{
			System.out.println("Committee Status: null");
		}
		else
		{
			System.out.println("Committee Status: "+this.getCommitteeStatus().getCampName());
		}
		System.out.println("Point: "+this.point);
		System.out.println("Days occupied: "+this.getDaysOccupied());

	}


	public abstract void start() ;

	public void writeToStudentCSV()
	{
		String header = "User ID,email address,Name,Faculty, Committee Status, Days Occupied\n";
		CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME,header);
		//String csvData = String.join(",", this.enquiryId, this.sender, this.camp, this.status, this.dealer.getName(), this.content);
		String csvData=toCsvString();
		try {
			csvModifier.checkCreateOrUpdate(this.getUserID(), csvData);
		} catch (IOException e) {
			System.out.println("An I/O error occurred while creating the new account.");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("The cryptographic algorithm is not available in the current environment.");
			e.printStackTrace();
		}
	}

	public boolean deleteStudent(String onlyID) throws IOException {
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

	public String toCsvString() {
		String studentIDStr = (this.getUserID() == null) ? "" : this.getUserID();
		String emailAddress = this.getUserID()+"@e.ntu.edu.sg";
		String name = (this.getName() == null) ? "" : this.getName();
		String facultyStr = (this.getFaculty()==null) ? "": this.getFaculty().toString();
		String committeeStatus = (this.getCommitteeStatus().getCampName()==null) ? "":this.getCommitteeStatus().getCampName();
		String occupiedDates = daysOccupied.stream()
				.map(LocalDate::toString)
				.collect(Collectors.joining("+"));

		return String.join(",",
				studentIDStr,
				emailAddress,
				name,
				facultyStr,
				committeeStatus,
				occupiedDates);
	}

}