package Package;

import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Package.Camp;
import Package.Sorter;
import Package.Student;
import Package.StudentStatus;

public class Enquiry extends Report {
	public Enquiry(Camp camp){
		super(camp);
	}
	/**
	 * 
	 * @param camp
	 */
	public ArrayList<Enquiry> report(Camp camp) {
		ArrayList<Enquiry> enquiryList = Sorter.sortByStudentType(camp,StudentStatus.CommitteeMember); // select the list
        System.out.println("The list of sorting methods shows below: ");
		ArrayList<Enquiry> sortedenquiryList = SorterDisplay.displaySortingMethod(enquiryList, this); // Sort the list
        return sortedenquiryList; // Return the sorted list
    }

    public void GenerateReport(Camp camp){
        //gai
		ArrayList<Enquiry> sortedenquiryList = this.report(camp);
		String fileName = camp.getCampName()+"EnquiryReport";
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
			reportModifier.checkCreateOrUpdate(camp.getCampName(), campCsvData);
			// Write enquiries header
			String enquiriesHeader = "UserID, Name, Faculty, Committee Status, Point";
			reportModifier.checkCreateOrUpdate("-1", enquiriesHeader);

			// Loop through the sorted enquiry list and write each enquiry's data
			for (Student enquiry : sortedenquiryList) {
                //gai
				String committeeStatus = "NULL";
				if (student.getCommitteeStatus()==camp){
					committeeStatus = "Committee";
				}
				String enquiryCsvData = String.join(",", enquiry.getUserID(), enquiry.getName(), enquiry.getFaculty().name(), committeeStatus, String.valueOf(student.getPoint()));
				reportModifier.checkCreateOrUpdate(student.getUserID(), enquiryCsvData);
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
