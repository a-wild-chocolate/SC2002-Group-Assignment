package Package;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PerformanceReport extends Report {
	public PerformanceReport(Camp camp){
		super(camp);
	}
	/**
	 * 
	 * @param camp
	 */
	public ArrayList<Student> report(Camp camp) {
		ArrayList<Student> studentList = Sorter.sortByStudentType(camp,StudentStatus.CommitteeMember); // select the list
        System.out.println("The list of aorting methods shows below: ");
		ArrayList<Student> sortedStudentList = SorterDisplay.displaySortingMethod(studentList, this); // Sort the list
        return sortedStudentList; // Return the sorted list
    }

	public void GenerateReport(Camp camp){
		ArrayList<Student> sortedstudentList = this.report(camp);
		String fileName = camp.getCampName()+"Report";
        String header = "Camp Name, Dates, Registration closing date, User group, Location, Total Slots, Camp Committee Slots, Description, Staff in charge";
        
        // Create CSVReadWriter object
        CSVReadWriter reportModifier = new CSVReadWriter(fileName, header);

        // Combine camp data into a CSV string
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        // Convert LocalDate to String using the formatter
		String facultiesAsString = camp.getUserGroup().stream()
                .map(Faculty::name)
                .collect(Collectors.joining(","));
        String campCsvData = String.join(",", camp.getCampName(), camp.getDate().format(formatter), camp.getRegistrationDate().format(formatter), facultiesAsString, camp.getLocation(), String.valueOf(camp.getRemainSlot()), String.valueOf(camp.getCommitteeSlot()), camp.getDescription(), camp.getStaffInCharge().getName());
        
        // Write camp data to CSV
        
		try {
			reportModifier.createNewRecord(camp.getCampName(), campCsvData);
			// Write students header
			String studentsHeader = "UserID, Name, Faculty, Committee Status, Point";
			reportModifier.createNewRecord("-1", studentsHeader);

			// Loop through the sorted student list and write each student's data
			for (Student student : sortedstudentList) {
				String committeeStatus = "NULL";
				if (student.getCommitteeStatus()==camp){
					committeeStatus = "Committee";
				}
				String studentCsvData = String.join(",", student.getUserID(), student.getName(), student.getFaculty().name(), committeeStatus, String.valueOf(student.getPoint()));
				reportModifier.createNewRecord(student.getUserID(), studentCsvData);
			}

		} catch (IOException e) {
			System.out.println("An I/O error occurred while creating the new account.");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("The cryptographic algorithm is not available in the current environment.");
			e.printStackTrace();
		}
    }

}