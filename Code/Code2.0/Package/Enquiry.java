package Package;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

public class Enquiry {

	private Camp camp;

	private final Attendee sender;
	private String content;

	private EnquiryStatus status;
	private static int enquiryNumber = 0;

	private final int enquiryId;

	private EnquiryReply reply;

	private final String FILE_NAME = "enquiry";
//for user
	public Enquiry(String content,Camp camp,Attendee sender)
	{
		this.camp=camp;
		this.content=content;
		this.enquiryId=enquiryNumber;
		enquiryNumber++;
		this.reply=null;
		this.status=EnquiryStatus.pending;
		this.sender=sender;
	}
//for csv writer
	public Enquiry(int enquiryId, String content,Camp camp, EnquiryReply reply, EnquiryStatus status,Attendee sender)
	{
		this.camp=camp;
		this.enquiryId=enquiryId;
		this.content=content;
		this.reply=reply;
		this.status=status;
		this.sender=sender;
	}

	public Attendee getSender() {
		return sender;
	}

	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public int getEnquiryId() {
		return enquiryId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public EnquiryReply getReply() {
		return reply;
	}

	public void setReply(EnquiryReply reply) {
		this.reply = reply;
	}

	public EnquiryStatus getStatus() {
		return this.status;
	}

	/**
	 * @param status
	 */
	public void setStatus(EnquiryStatus status) {
		this.status = status;
	}

	public void printWithoutReply()
	{
		EnquiryPrinter ep=new EnquiryPrinter(this);
		ep.printEnquiryWithoutReply();
	}

	public void printWithReply()
	{
		EnquiryPrinter ep=new EnquiryPrinter(this);
		ep.printEnquiryWithReply();
	}

	//CSV method
	public void writeToEnquiryCSV()
	{
		String header = "Enquiry ID,Sender Name,Camp Name,Status,Content,Reply\n";
        CSVReadWriter csvModifier = new CSVReadWriter(FILE_NAME,header);
		//String csvData = String.join(",", this.enquiryId, this.sender, this.camp, this.status, this.dealer.getName(), this.content);
        String csvData=toCsvString();		
		try {
		csvModifier.checkCreateOrUpdate(Integer.toString(enquiryId), csvData);
		} catch (IOException e) {
        System.out.println("An I/O error occurred while creating the new account.");
        e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("The cryptographic algorithm is not available in the current environment.");
			e.printStackTrace();
		}	
	}

	public boolean deleteAccount(String onlyID) throws IOException {
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
		String senderStr = (sender == null) ? "" : sender.toString();
		String campStr = (camp == null) ? "" : camp.toString();
		String statusStr = (status == null) ? "" : status.toString();
		String contentStr = (content == null) ? "" : content;
		String replyStr = (reply == null) ? "" : reply;


		return String.join(",", 
			Integer.toString(enquiryId), 
			senderStr, 
			campStr, 
			statusStr, 
			contentStr,
			replyStr);
	}
}



