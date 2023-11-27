package Package.Enquiry;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import Package.CSVManager.CSVReadWriter;
import Package.Camp.*;
import Package.Enum.*;

import Package.Report.Report;
import Package.Sort.SorterDisplay;

public class EnquiryReport extends Report {
	public EnquiryReport(Camp camp){
		super(camp);
	}
	/**
	 * 
	 * @param camp
	 */
	public ArrayList<Enquiry> report(Camp camp) {
		ArrayList<Enquiry> enquiryList = camp.getEnquiryList();// Get the list of enquiry
		
		//Sorter.sortByStatus(camp,StudentStatus.CommitteeMember); // select the list
        System.out.println("The list of sorting methods shows below: ");
		ArrayList<Enquiry> sortedenquiryList = SorterDisplay.displaySortingEnquiryList(enquiryList); // Sort the list
        return sortedenquiryList; // Return the sorted list
    }

    public void GenerateReport(Camp camp){
        //gai
		ArrayList<Enquiry> sortedenquiryList = this.report(camp);
		String fileName ="./"+ camp.getCampName()+"EnquiryReport";
        String header = "Camp Name, Dates, Registration closing date, User group, Location, Total Slots, Camp Committee Slots, Description, Staff in charge\n";
        
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
			String enquiriesHeader = "Enquiry ID,Sender Name,Camp Name,Status,Content,Reply";
			reportModifier.checkCreateOrUpdate("-1", enquiriesHeader);

			// Loop through the sorted enquiry list and write each enquiry's data
			for (Enquiry enquiry : sortedenquiryList) {
                //gai
				String enquiryCsvData = enquiry.toCsvString();
				reportModifier.checkCreateOrUpdate(Integer.toString(enquiry.getEnquiryId()), enquiryCsvData);
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
